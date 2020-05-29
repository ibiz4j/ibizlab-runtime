package cn.ibizlab.core.ou.extensions.domain;

import cn.ibizlab.core.ou.domain.IBZDepartment;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class DeptMap {
    private String deptid;
    private IBZDepartment dept;
    private Set<String> parent=new LinkedHashSet<>();
    private Set<String> sub=new LinkedHashSet<>();
    private Set<String> father=new LinkedHashSet<>();
    private Set<String> children=new LinkedHashSet<>();

    public String getDeptid()
    {
        if(StringUtils.isEmpty(deptid)&&dept!=null)
            deptid=dept.getDeptid();
        return deptid;
    }

    public Set<String> getSub()
    {
        if(sub.size()==0&&(dept!=null||(!StringUtils.isEmpty(getDeptid()))))
            sub.add(getDeptid());
        return sub;
    }

    public Set<String> getParent()
    {
        if(parent.size()==0&&dept!=null&&(!StringUtils.isEmpty(dept.getParentdeptid())))
            parent.add(dept.getParentdeptid());
        return parent;
    }

    public Set<String> getFather()
    {
        if(father.size()==0&&getParent().size()>0)
            father.add(parent.iterator().next());
        return father;
    }
}
