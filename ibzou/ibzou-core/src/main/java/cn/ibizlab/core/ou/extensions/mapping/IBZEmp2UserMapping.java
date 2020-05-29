package cn.ibizlab.core.ou.extensions.mapping;

import cn.ibizlab.core.ou.domain.IBZEmployee;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IBZEmp2UserMapping extends MappingBase<IBZUSER, IBZEmployee>
{


}

