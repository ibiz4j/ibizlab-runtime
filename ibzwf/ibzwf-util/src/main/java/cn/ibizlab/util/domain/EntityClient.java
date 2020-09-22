package cn.ibizlab.util.domain;

import org.springframework.util.StringUtils;

public class EntityClient extends EntityBase {

    @Override
    public void modify(String field,Object val) {
        if(val==null){
            this.getFocusNull().add(field.toLowerCase());
            getExtensionparams().put("dirtyflagenable",true);
            getExtensionparams().put(field.toLowerCase()+"dirtyflag",true);
        }
        else{
            this.getFocusNull().remove(field.toLowerCase());
            getExtensionparams().remove(field.toLowerCase()+"dirtyflag");
        }
    }

    @Override
    public void reset(String field) {
        if(!StringUtils.isEmpty(field)){
            String resetField=field.toLowerCase();
            this.set(resetField,null);
            this.getFocusNull().remove(resetField);
            getExtensionparams().remove(resetField+"dirtyflag");
        }
    }
}

