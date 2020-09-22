package cn.ibizlab.util.domain;

import cn.ibizlab.util.helper.DEFieldCacheMap;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.data.annotation.Transient;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.ObjectUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import org.springframework.util.StringUtils;
import java.util.*;

public class EntityBase implements Serializable {

    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    private Set<String> focusNull;

    public Set<String> getFocusNull() {
        if(focusNull==null)
            focusNull=new HashSet<>();
        return focusNull;
    }

    public void setFocusNull(Set<String> focusNull) {
        this.focusNull = focusNull;
    }

    public void modify(String field,Object val) {

    }

    public Serializable getDefaultKey(boolean gen) {
        String Id=(new AlternativeJdkIdGenerator()).generateId().toString();
        return gen?Id.replace("-", ""):Id;
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    @Transient
    private BeanMap map;

    private BeanMap getMap()
    {
        if(map==null)
            map=BeanMap.create(this);
        return  map;
    }

    @JsonIgnore
    @TableField(exist = false)
    @Transient
    private Map<String,Object> extensionparams=new HashMap<String,Object>();

    public Map<String, Object> getExtensionparams() {
        return extensionparams;
    }

    public void setExtensionparams(Map<String, Object> extensionparams) {
        this.extensionparams = extensionparams;
    }



    public Object get(String field) {
        String fieldRealName=DEFieldCacheMap.getFieldRealName(this.getClass(),field);
        if(!StringUtils.isEmpty(fieldRealName))
            return getMap().get(fieldRealName);
        else
            return this.extensionparams.get(field.toLowerCase());
    }


    @JsonAnyGetter
    public Map<String , Object> any() {
        return extensionparams;
    }

    @JsonAnySetter
    public void set(String field, Object value) {
        field=field.toLowerCase();
        String fieldRealName=DEFieldCacheMap.getFieldRealName(this.getClass(),field);
        if(!StringUtils.isEmpty(fieldRealName)) {
            if (value == null)
                getMap().put(fieldRealName, null);
            else
                getMap().put(fieldRealName, DEFieldCacheMap.fieldValueOf(this.getClass(), fieldRealName, value));
        }
        else
            this.extensionparams.put(field.toLowerCase(),value);
    }

    /**
    * 复制当前对象数据到目标对象
    * @param targetEntity 目标数据对象
    * @param bIncEmpty  是否包括空值
    * @param <T>
    * @return
    */
    public <T> T copyTo(T targetEntity, boolean bIncEmpty){
        if(targetEntity instanceof EntityBase){
            EntityBase target= (EntityBase) targetEntity;
            Hashtable<String, Field> sourceFields=DEFieldCacheMap.getFieldMap(this.getClass());
            for(String field : sourceFields.keySet()){
                Object value=this.get(field);
                if( !ObjectUtils.isEmpty(value) ||  ObjectUtils.isEmpty(value) &&  getFocusNull().contains(field) &&  bIncEmpty ){
                    target.set(field,value);
                }
            }
        }
        return targetEntity;
    }

    /**
    * 重置当前数据对象属性值
    * @param field
    */
    public void reset(String field){

    }
}