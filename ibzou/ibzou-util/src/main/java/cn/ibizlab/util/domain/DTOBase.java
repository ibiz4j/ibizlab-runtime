package cn.ibizlab.util.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.data.annotation.Transient;
import org.springframework.util.StringUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class DTOBase implements Serializable {


    @JsonIgnore
    @JSONField(serialize = false)
    private Set<String> focusNull;


    public void modify(String field,Object val) {
        if(val==null) {
            this.getFocusNull(true).add(field.toLowerCase());
        }
        else {
            this.getFocusNull(true).remove(field.toLowerCase());
        }
    }


    public Set<String> getFocusNull() {
        if(focusNull==null) {
            focusNull=new HashSet<>();
        }
        if(focusNull.size()>0 && extensionparams.containsKey("dirtyflagenable"))
        {
            Set<String> nocheck=new HashSet<>();
            for(String key:focusNull)
            {
                if(!extensionparams.containsKey(key+"dirtyflag")) {
                    nocheck.add(key);
                }
            }
            for(String key:nocheck) {
                focusNull.remove(key);
            }
        }
        return focusNull;
    }

    private Set<String> getFocusNull(boolean newflag) {
        if(focusNull==null) {
            focusNull=new HashSet<>();
        }
        return focusNull;
    }

    @JsonIgnore
    private Map<String,Object> extensionparams=new HashMap<String,Object>();

    public Map<String, Object> getExtensionparams() {
        return extensionparams;
    }

    public void setExtensionparams(Map<String, Object> extensionparams) {
        this.extensionparams = extensionparams;
    }

    @JsonAnyGetter
    public Map<String , Object> any() {
        return extensionparams;
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Transient
    private BeanMap map;

    private BeanMap getMap()
    {
        if(map==null) {
            map=BeanMap.create(this);
        }
        return  map;
    }

    public Object get(String field) {
        String fieldRealName= DEFieldCacheMap.getFieldRealName(this.getClass(),field);
        if(!StringUtils.isEmpty(fieldRealName)) {
            return getMap().get(fieldRealName);
        }
        else {
            return this.extensionparams.get(field.toLowerCase());
        }
    }

    @JsonAnySetter
    public void set(String field, Object value) {
        field=field.toLowerCase();
        String fieldRealName=DEFieldCacheMap.getFieldRealName(this.getClass(),field);
        if(!StringUtils.isEmpty(fieldRealName)) {
            if (value == null) {
                getMap().put(fieldRealName, null);
            }
            else {
                getMap().put(fieldRealName, DEFieldCacheMap.fieldValueOf(this.getClass(), fieldRealName, value));
            }
        }
        else {
            this.extensionparams.put(field.toLowerCase(),value);
        }
    }
}

