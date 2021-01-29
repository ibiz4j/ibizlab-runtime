package cn.ibizlab.core.dict.extensions.service;

import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;
import cn.ibizlab.core.dict.filter.DictOptionSearchContext;
import cn.ibizlab.core.dict.service.IDictCatalogService;
import cn.ibizlab.core.dict.service.IDictOptionService;
import cn.ibizlab.util.dict.Catalog;
import cn.ibizlab.util.dict.CodeItem;
import cn.ibizlab.util.dict.CodeList;
import cn.ibizlab.util.dict.Option;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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

        if(code.equalsIgnoreCase("dictcatalog"))
        {
            catalog.setCode("DictCatalog");
            catalog.setName("字典目录");
            List<Option> list = new ArrayList<>();
            LambdaQueryWrapper<DictCatalog> wrapper=Wrappers.lambdaQuery();
            if(!StringUtils.isEmpty(context.getN_val_like()))
                wrapper.like(DictCatalog::getCode,context.getN_val_like());
            if(!StringUtils.isEmpty(context.getN_val_in()))
                wrapper.in(DictCatalog::getCode,context.getN_val_in());
            if(!StringUtils.isEmpty(context.getN_val_leftlike()))
                wrapper.likeRight(DictCatalog::getCode,context.getN_val_leftlike());
            if(!StringUtils.isEmpty(context.getN_val_notin()))
                wrapper.notIn(DictCatalog::getCode,context.getN_val_notin());
            if(!StringUtils.isEmpty(context.getN_label_like()))
                wrapper.notIn(DictCatalog::getName,context.getN_label_like());
            if(!StringUtils.isEmpty(context.getN_vfilter_like()))
                wrapper.like(DictCatalog::getGroup,context.getN_vfilter_like());
            if(!StringUtils.isEmpty(context.getN_vfilter_in()))
                wrapper.in(DictCatalog::getGroup,context.getN_vfilter_in());
            if(!StringUtils.isEmpty(context.getN_vfilter_leftlike()))
                wrapper.likeRight(DictCatalog::getGroup,context.getN_vfilter_leftlike());
            if(!StringUtils.isEmpty(context.getN_vfilter_eq()))
                wrapper.eq(DictCatalog::getGroup,context.getN_vfilter_eq());
            wrapper.orderByAsc(DictCatalog::getGroup,DictCatalog::getCode);

            dictCatalogService.list(wrapper).forEach(item->{
                list.add(new Option().setValue(item.getCode()).setId(item.getCode())
                        .setDisabled(false)
                        .setFilter(item.getGroup()).setLabel(item.getName())
                );
            });
            catalog.setOptions(list);
        }
        else
        {
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
        }
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

        if(code.equalsIgnoreCase("dictcatalog"))
        {
            catalog.setCode("DictCatalog");
            catalog.setName("字典目录");
            List<CodeItem> list = new ArrayList<>();
            LambdaQueryWrapper<DictCatalog> wrapper=Wrappers.lambdaQuery();
            if(!StringUtils.isEmpty(context.getN_val_like()))
                wrapper.like(DictCatalog::getCode,context.getN_val_like());
            if(!StringUtils.isEmpty(context.getN_val_in()))
                wrapper.in(DictCatalog::getCode,context.getN_val_in());
            if(!StringUtils.isEmpty(context.getN_val_leftlike()))
                wrapper.likeRight(DictCatalog::getCode,context.getN_val_leftlike());
            if(!StringUtils.isEmpty(context.getN_val_notin()))
                wrapper.notIn(DictCatalog::getCode,context.getN_val_notin());
            if(!StringUtils.isEmpty(context.getN_label_like()))
                wrapper.notIn(DictCatalog::getName,context.getN_label_like());
            if(!StringUtils.isEmpty(context.getN_vfilter_like()))
                wrapper.like(DictCatalog::getGroup,context.getN_vfilter_like());
            if(!StringUtils.isEmpty(context.getN_vfilter_in()))
                wrapper.in(DictCatalog::getGroup,context.getN_vfilter_in());
            if(!StringUtils.isEmpty(context.getN_vfilter_leftlike()))
                wrapper.likeRight(DictCatalog::getGroup,context.getN_vfilter_leftlike());
            if(!StringUtils.isEmpty(context.getN_vfilter_eq()))
                wrapper.eq(DictCatalog::getGroup,context.getN_vfilter_eq());
            wrapper.orderByAsc(DictCatalog::getGroup,DictCatalog::getCode);

            dictCatalogService.list(wrapper).forEach(item->{
                list.add(new CodeItem().setValue(item.getCode()).setId(item.getCode())
                        .setDisabled(false)
                        .setFilter(item.getGroup()).setLabel(item.getName())
                );
            });
            catalog.setOptions(list);
        }
        else {
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
            catalog.setOptions(list);
        }



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
