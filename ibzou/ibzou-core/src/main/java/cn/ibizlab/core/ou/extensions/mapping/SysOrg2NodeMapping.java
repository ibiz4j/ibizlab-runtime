package cn.ibizlab.core.ou.extensions.mapping;

import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.extensions.domain.OrgNode;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysOrg2NodeMapping extends MappingBase<OrgNode, SysOrganization>
{


}

