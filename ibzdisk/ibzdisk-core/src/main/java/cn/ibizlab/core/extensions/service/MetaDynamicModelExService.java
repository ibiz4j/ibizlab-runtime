package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.disk.domain.MetaDynamicModel;
import cn.ibizlab.core.disk.extensions.service.DiskCoreService;
import cn.ibizlab.core.disk.service.IMetaDynamicModelService;
import cn.ibizlab.core.disk.service.impl.MetaDynamicModelServiceImpl;
import cn.ibizlab.util.cache.listener.RedisPublisher;
import cn.ibizlab.util.client.IBZWFFeignClient;
import cn.ibizlab.util.dict.StaticDict;
import cn.ibizlab.util.domain.FileItem;
import cn.ibizlab.util.enums.RedisChannelTopic;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.errors.InternalServerErrorException;
import cn.ibizlab.util.helper.FileHelper;
import cn.ibizlab.util.service.FileService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实体[动态模型] 自定义服务对象
 */
@Slf4j
@Primary
@Service("MetaDynamicModelExService")
public class MetaDynamicModelExService extends MetaDynamicModelServiceImpl {

    private static final String wf_regex="\\w+WFv\\d+.json.bpmn";

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    @Autowired
    DiskCoreService diskCoreService;

    @Autowired
    private IMetaDynamicModelService dynamicModelService;

    @Autowired
    @Lazy
    private IBZWFFeignClient wfClient;

    @Value("${ibiz.dynamic.publishpath:/app/file/dynamicModel/publicpath}")
    private String publishPath;

    @Autowired
    @Lazy
    RedisTemplate<String, Object> redisOperations;

    @Override
    public boolean create(MetaDynamicModel et) {
        et.setConfigid((String)et.getDefaultKey(true));
        JSONObject system =  unzip(et);
        boolean result = super.create(et);
        createSubDynaInst(et,system);
        return result;
    }

    @Override
    public boolean update(MetaDynamicModel et) {
        JSONObject system =  unzip(et);
        boolean result = super.update(et);
        createSubDynaInst(et,system);
        return result;
    }

    /**
     * 将zip解压到file目录
     *
     * @param et
     */
    private JSONObject unzip(MetaDynamicModel et) {
        try {
            File modelFile = null;
            JSONObject system = null;
            String strModelFile = et.getModelfile();
            if (StringUtils.isEmpty(strModelFile)){
                throw new BadRequestAlertException("模型文件为空", "MetaDynamicModel", "unzip");
            }
            List<FileItem> items = JSONArray.parseArray(strModelFile, FileItem.class);
            if (!ObjectUtils.isEmpty(items) && items.size() > 1) {
                throw new BadRequestAlertException("单次只允许上传一个模型文件", "MetaDynamicModel", "unzip");
            }
            File parent = diskCoreService.getFile(items.get(0).getId());
            if (parent.exists()) {
                modelFile = parent;
            } else {
                throw new InternalServerErrorException("文件未找到");
            }
            String unzipPath = modelFile.getParent().replace("ibizutil", "dynamicmodel");
            if(".tar.gz".equals(modelFile.getName().substring(modelFile.getName().indexOf(".")))){
                FileHelper.unTarGz(modelFile, unzipPath, true);
                system = getSystem(unzipPath);
            }else if(".zip".equals(modelFile.getName().substring(modelFile.getName().lastIndexOf(".")))){
                FileHelper.unzip(modelFile, unzipPath, true);
                system = getSystem(unzipPath);
            }else{
                throw new BadRequestAlertException("文件后缀名异常，请以zip或tar.gz作为后缀名", "MetaDynamicModel", "unzip");
            }
            if(!ObjectUtils.isEmpty(system)) {
                String dynainst = system.getString("getPSDynaInstId");
                String sysid = system.getString("name");
                if(!StringUtils.isEmpty(dynainst))
                    et.setDynainstid(dynainst);
                if(!StringUtils.isEmpty(sysid))
                    et.setSystemId(sysid);
            }
            return system;
        } catch (IOException e) {
            throw new BadRequestAlertException("解析动态模型文件失败，" + e, "MetaDynamicModel", "unzip");
        }
    }

    /**
     * 创建副本实例
     * @param et
     * @param system
     * @return
     */
    private void createSubDynaInst(MetaDynamicModel et,JSONObject system){
        if(!ObjectUtils.isEmpty(system)){
            JSONArray array = system.getJSONArray("getPSDynaInsts");
            List<MetaDynamicModel> metaDynamicModels = new ArrayList<>();
            if(!ObjectUtils.isEmpty(array)){
                for(int i = 0; i < array.size(); i++) {
                    MetaDynamicModel model = new MetaDynamicModel();
                    JSONObject obj = array.getJSONObject(i);
                    model.setConfigname(obj.get("name").toString());
                    model.setDynainstid(obj.get("id").toString());
                    model.setConfigid(DigestUtils.md5DigestAsHex(String.format("%s||%s" ,et.getSystemId(),obj.get("id").toString()).getBytes()));
                    model.setStatus("0");
                    model.setPdynainstid(et.getConfigid());
                    model.setSystemId(et.getSystemId());
                    metaDynamicModels.add(model);
                }
                dynamicModelService.saveOrUpdateBatch(metaDynamicModels);
            }
        }
    }

    /**
     * 发布动态模型
     *
     * @param et
     */
    @SneakyThrows
    @Override
    public MetaDynamicModel publish(MetaDynamicModel et) {
        et = get(et.getConfigid());
        String systemId = et.getSystemId();
        String dynamicId = et.getDynainstid();
        String strModelFile = et.getModelfile();
        if (StringUtils.isEmpty(strModelFile) && StringUtils.isEmpty(et.getSystemId()))
            throw new BadRequestAlertException(String.format("信息不足，请检查[%s]模型数据是否存在系统标识及模型文件", et.getConfigid()), "MetaDynamicModel", "publish");
        List<FileItem> items = JSONArray.parseArray(strModelFile, FileItem.class);
        if (!ObjectUtils.isEmpty(items) && items.size() > 1)
            throw new BadRequestAlertException(String.format("模型解析失败，[%s]模型文件过多", et.getConfigid()), "MetaDynamicModel", "publish");
        File publishFile = new File(getPublishPath() + systemId + File.separator + et.getDynainstid());
        //删除发布目录中的历史文件
        if (publishFile.exists()) {
            FileHelper.deleteDir(publishFile.getPath());
        }
        if(ObjectUtils.isEmpty(items)){
            throw new BadRequestAlertException(String.format("文件不存在,请在发布前确认文件是否已经上传！", et.getConfigid()), "MetaDynamicModel", "publish");
        }
        File modelFile = diskCoreService.getFile(items.get(0).getId());
        String unzipPath = modelFile.getParent().replace("ibizutil", "dynamicmodel");
        File unzipFile = new File(unzipPath);
        //拷贝文件到发布目录
        FileHelper.copyFolder(unzipFile.getPath(), publishFile.getParent());
        File dynamicFile = new File(publishFile.getParent() + File.separator + unzipFile.getName());
        if (dynamicFile.exists()) {
            dynamicFile.renameTo(publishFile);
        }
        List<Map<String, Object>> workflow = searchWorkFlow(publishFile.getPath());
        //部署流程
        if (workflow.size() > 0) {
            wfClient.deployDynaWF(workflow,et.getDynainstid());
        }
        //发送redis广播
        Map<String, Object> message = new HashMap<>();
        message.put("cacheName", "dynamicModel");
        message.put("dynamicModel", et.getConfigname());
        RedisPublisher redisPublisher = new RedisPublisher(redisOperations, RedisChannelTopic.REDIS_CACHE_DYNAMICMODEL_TOPIC.getChannelTopic());
        redisPublisher.publisher(message);
        //激活当前et.
        et.setStatus(StaticDict.DynamicModelStatus.ITEM_1.getValue());
        update(Wrappers.<MetaDynamicModel>lambdaUpdate().set(MetaDynamicModel::getStatus, StaticDict.DynamicModelStatus.ITEM_0.getValue()).eq(MetaDynamicModel::getSystemId, systemId).eq(MetaDynamicModel::getDynainstid, dynamicId));
        update(et);
        return et;
    }


    /**
     * 从查询工作流 bpmn
     *
     * @param pubPath
     * @return
     */
    public List<Map<String, Object>> searchWorkFlow(String pubPath) {
        List<Map<String, Object>> models = new ArrayList<>();
        File publish = new File(pubPath);
        if (!publish.exists()) {
            throw new BadRequestAlertException(String.format("发布目录[%s]不存在", publish.getPath()), "MetaDynamicModel", "searchWorkFlow");
        }
        File[] subFiles = publish.listFiles();
        if (null != subFiles) {
            for (File subFile : subFiles) {
                if (subFile.isDirectory()) {
                    List<Map<String, Object>> subModels = searchWorkFlow(subFile.getAbsolutePath());
                    if (!ObjectUtils.isEmpty(subModels)) {
                        models.addAll(subModels);
                    }
                } else if (subFile.isFile() && (subFile.getName().matches(wf_regex))) {
                    InputStream file = null;
                    try {
                        file = new FileInputStream(subFile);
                        Map fileMap = new HashMap();
                        fileMap.put(subFile.getName(), IOUtils.toString(file, "UTF-8"));
                        models.add(fileMap);
                    } catch (IOException e) {
                    } finally {
                        try {
                            if (file != null) {
                                file.close();
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            }
        }
        return models;
    }

    /**
     * 获取发布目录
     *
     * @return
     */
    public String getPublishPath() {
        if (!StringUtils.isEmpty(publishPath)) {
            publishPath = publishPath.replace("\\\\", File.separator).replace("\\", File.separator).replace("/", File.separator);
            if (!publishPath.endsWith(File.separator)) {
                publishPath = publishPath + File.separator + "net-disk" + File.separator;
            }
        }
        return publishPath;
    }


    /**
     * 获取系统标识
     *
     * @param filePath
     * @return
     */
    private JSONObject getSystem(String filePath) throws UnsupportedEncodingException {
        JSONObject system = null;
        InputStream in = null;
        byte[] bytes = null;
        try {
            File file = new File(filePath + File.separator + "PSSYSTEM.json");
            if (!file.exists()) {
                throw new BadRequestAlertException(String.format("无法找到动态系统模型文件[%s]", file.getPath()), "MetaDynamicModel", "getSystem");
            }
            in = new FileInputStream(file);
            bytes = new byte[in.available()];
            in.read(bytes);
        } catch (Exception e) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        if (bytes != null) {
            String strSystem = new String(bytes,"utf8");
            if (!StringUtils.isEmpty(strSystem)) {
                system = JSONObject.parseObject(strSystem);
            }
        }
        if (ObjectUtils.isEmpty(system)) {
            throw new BadRequestAlertException("无法获取系统标识", "MetaDynamicModel", "getSystem");
        }
        return system;
    }
}

