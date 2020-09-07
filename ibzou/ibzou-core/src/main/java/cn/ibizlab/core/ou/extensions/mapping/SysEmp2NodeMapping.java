package cn.ibizlab.core.ou.extensions.mapping;

import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.core.ou.extensions.domain.EmpNode;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysEmp2NodeMapping extends MappingBase<EmpNode, SysEmployee>
{


}

