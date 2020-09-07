package cn.ibizlab.core.ou.extensions.domain;

import cn.ibizlab.core.ou.domain.SysOrganization;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class OrgMap {
    private String orgid;
    private SysOrganization org;
    private Set<String> parent=new LinkedHashSet<>();
    private Set<String> sub=new LinkedHashSet<>();
    private Set<String> father=new LinkedHashSet<>();
    private Set<String> children=new LinkedHashSet<>();

    public String getOrgid()
    {
        if(StringUtils.isEmpty(orgid)&&org!=null)
            orgid=org.getOrgid();
        return orgid;
    }

    public Set<String> getSub()
    {
        if(sub.size()==0&&(org!=null||(!StringUtils.isEmpty(getOrgid()))))
            sub.add(getOrgid());
        return sub;
    }

    public Set<String> getParent()
    {
        if(parent.size()==0&&org!=null&&(!StringUtils.isEmpty(org.getParentorgid())))
            parent.add(org.getParentorgid());
        return parent;
    }

    public Set<String> getFather()
    {
        if(father.size()==0&&getParent().size()>0)
            father.add(parent.iterator().next());
        return father;
    }
}
