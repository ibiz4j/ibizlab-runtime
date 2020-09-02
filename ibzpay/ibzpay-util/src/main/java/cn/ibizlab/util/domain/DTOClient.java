package cn.ibizlab.util.domain;

public class DTOClient extends DTOBase {

    @Override
    public void modify(String field,Object val) {
        getExtensionparams().put("dirtyflagenable",true);
        if(val==null){
            this.getFocusNull().add(field.toLowerCase());
            getExtensionparams().put(field.toLowerCase()+"dirtyflag",true);
        }
        else{
            this.getFocusNull().remove(field.toLowerCase());
            getExtensionparams().remove(field.toLowerCase()+"dirtyflag");
        }
    }
}

