package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.ou.domain.SysDeptMember;
import cn.ibizlab.api.dto.SysDeptMemberDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},implementationName="apiSysDeptMemberMapping",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysDeptMemberMapping extends MappingBase<SysDeptMemberDTO, SysDeptMember> {


}

