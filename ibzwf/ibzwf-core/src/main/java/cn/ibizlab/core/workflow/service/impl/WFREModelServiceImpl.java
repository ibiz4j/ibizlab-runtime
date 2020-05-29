package cn.ibizlab.core.workflow.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import cn.ibizlab.core.workflow.extensions.service.WFCoreService;
import cn.ibizlab.util.domain.FileItem;
import cn.ibizlab.util.service.FileService;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.workflow.domain.WFREModel;
import cn.ibizlab.core.workflow.filter.WFREModelSearchContext;
import cn.ibizlab.core.workflow.service.IWFREModelService;

import org.springframework.util.StringUtils;

/**
 * 实体[流程模型] 无存储服务对象接口实现
 */
@Slf4j
@Service
public class WFREModelServiceImpl implements IWFREModelService {



    @Override
    public boolean update(WFREModel et) {
        publish(et);
        return true;
    }

    public void updateBatch(List<WFREModel> list){
                    
    }

    @Override
    @Transactional
    public boolean save(WFREModel et) {
        return true;
    }

    @Override
    public void saveBatch(List<WFREModel> list) {
                       
    }

    @Override
    public WFREModel get(String id) {
        return new WFREModel();
    }

    @Override
    public boolean create(WFREModel et) {
        publish(et);
        return true;
    }


    @Autowired
    private FileService fileService;

    @Autowired
    @Lazy
    private WFCoreService wfCoreService;

    public void publish(WFREModel et)
    {
        et.setName("");
        if(StringUtils.isEmpty(et.getBpmnfile()))
            return;

        List<FileItem> items= JSONArray.parseArray(et.getBpmnfile(),FileItem.class);
        if(items.size()==0)
            return;

        for(FileItem item:items)
        {
            File bpmnFile=fileService.getFile(item.getId());
            if(!bpmnFile.exists())
                return;
            wfCoreService.wfdeploy(bpmnFile,et);
        }

    }



    public void createBatch(List<WFREModel> list){

    }

    @Override
    public boolean checkKey(WFREModel et) {
        return false;
    }
    @Override
    public boolean remove(String id) {
        return true;
    }

    public void removeBatch(Collection<String> idList){
                        
    }

    @Override
    public WFREModel getDraft(WFREModel et) {
        return new WFREModel();
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFREModel> searchDefault(WFREModelSearchContext context) {
        return new PageImpl<WFREModel>(new ArrayList<>(),context.getPageable(),0);
    }


}

