package cn.ibizlab.core.dict.extensions.service;

import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.core.dict.extensions.vo.Catalog;
import cn.ibizlab.core.dict.extensions.vo.CodeItem;
import cn.ibizlab.core.dict.extensions.vo.CodeList;
import cn.ibizlab.core.dict.extensions.vo.Option;
import cn.ibizlab.core.dict.filter.DictOptionSearchContext;
import cn.ibizlab.core.dict.service.IDictCatalogService;
import cn.ibizlab.core.dict.service.IDictOptionService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DictCoreService
{
    @Autowired
    private IDictCatalogService dictCatalogService;


    @Autowired
    private IDictOptionService optionService;

    @Cacheable( value="dictcatalog",key = "'dict:'+#p0")
    public Catalog getDictCatalog(String code){
        return getDictCatalog(code,new DictOptionSearchContext());
    }
    public Catalog getDictCatalog(String code, DictOptionSearchContext context)
    {
        Catalog catalog = new Catalog();
        DictCatalog dictCatalog = dictCatalogService.getOne(Wrappers.<DictCatalog>query().eq("ccode",code));
        catalog.setCode(dictCatalog.getCode()).setName(dictCatalog.getName());


        List<Option> list = new ArrayList<>();
        optionService.list(context.getSelectCond().eq("cid",dictCatalog.getId()).orderByAsc("showorder")).forEach(item->{
            Map<String,Object> extension = new HashMap<>();
            if(!StringUtils.isEmpty(item.getExtension()))
                extension = JSONObject.parseObject(item.getExtension(),Map.class);
            list.add(new Option().setValue(item.getValue()).setId(item.getValue())
                    .setDisabled(((item.getDisabled()!=null && item.getDisabled()==1)||(item.getExpired()!=null && item.getExpired()==1))?true:false)
                    .setFilter(item.getFilter()).setIconClass(item.getIconClass()).setLabel(item.getLabel()).setParent(item.getParent()).setExtension(extension)
            );
        });

        List<Option> codeItemTreeList = new ArrayList<Option>();
        codeItemTreeList = loop(list, "");
        catalog.setOptions(codeItemTreeList);

        return catalog;
    }

    @CacheEvict(value="dictcatalog",key = "'dict:'+#p0")
    public void resetDictCatalog(String code)
    {

    }


    @Cacheable( value="dictcatalog",key = "'codelist:'+#p0")
    public CodeList getCodeListCatalog(String code){
        return getCodeListCatalog(code,new DictOptionSearchContext());
    }
    public CodeList getCodeListCatalog(String code, DictOptionSearchContext context)
    {
        CodeList catalog = new CodeList();
        DictCatalog dictCatalog = dictCatalogService.getOne(Wrappers.<DictCatalog>query().eq("ccode",code));
        catalog.setCode(dictCatalog.getCode()).setName(dictCatalog.getName());


        List<CodeItem> list = new ArrayList<>();
        optionService.list(context.getSelectCond().eq("cid",dictCatalog.getId()).orderByAsc("showorder")).forEach(item->{
            Map<String,Object> extension = new HashMap<>();
            if(!StringUtils.isEmpty(item.getExtension()))
                extension = JSONObject.parseObject(item.getExtension(),Map.class);
            list.add(new CodeItem().setValue(item.getValue()).setId(item.getValue())
                    .setDisabled(((item.getDisabled()!=null && item.getDisabled()==1)||(item.getExpired()!=null && item.getExpired()==1))?true:false)
                    .setFilter(item.getFilter()).setIconClass(item.getIconClass()).setLabel(item.getLabel()).setParent(item.getParent()).setExtension(extension)
            );
        });

//        List<CodeItem> codeItemTreeList = new ArrayList<CodeItem>();
//        codeItemTreeList = loopCodeItem(list, "");
        catalog.setOptions(list);

        return catalog;
    }

    @CacheEvict(value="dictcatalog",key = "'codelist:'+#p0")
    public void resetCodeListCatalog(String code)
    {

    }


    public List<Option> loop(List<Option> listCodeItem, Object parentValue) {
        List<Option> trees = new ArrayList<Option>();
        for (Option codeItem : listCodeItem) {
            String codeItemParentValue = codeItem.getParent();
            if (StringUtils.isEmpty(codeItemParentValue)) {
                codeItemParentValue = "";
            }
            if (parentValue.equals(codeItemParentValue)) {
                List<Option> childCodeItem = loop(listCodeItem, codeItem.getValue());
                if (childCodeItem.size() > 0) {
                    codeItem.setChildren(childCodeItem);
                }
                trees.add(codeItem);
            }
        }
        return trees;
    }

    public List<CodeItem> loopCodeItem(List<CodeItem> listCodeItem, Object parentValue) {
        List<CodeItem> trees = new ArrayList<CodeItem>();
        for (CodeItem codeItem : listCodeItem) {
            String codeItemParentValue = codeItem.getParent();
            if (StringUtils.isEmpty(codeItemParentValue)) {
                codeItemParentValue = "";
            }
            if (parentValue.equals(codeItemParentValue)) {
                List<CodeItem> childCodeItem = loopCodeItem(listCodeItem, codeItem.getValue());
                if (childCodeItem.size() > 0) {
                    codeItem.setChildren(childCodeItem);
                }
                trees.add(codeItem);
            }
        }
        return trees;
    }

    /**
     * 同步预置代码表
     * @param catalogs
     */
    public void syncRuntimeDict(List<DictCatalog> catalogs){
        List<DictOption> options=new ArrayList<>();
        for(DictCatalog catalog : catalogs){
            if(!ObjectUtils.isEmpty(catalog.getOptions()))
                options.addAll(catalog.getOptions());
        }
        if(catalogs.size()>0){
            dictCatalogService.saveBatch(catalogs);
        }
        if(options.size()>0){
            optionService.saveBatch(options);
        }
    }

}
