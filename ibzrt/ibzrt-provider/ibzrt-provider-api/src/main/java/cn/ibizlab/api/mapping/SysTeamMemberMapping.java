package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.ou.domain.SysTeamMember;
import cn.ibizlab.api.dto.SysTeamMemberDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},implementationName="apiSysTeamMemberMapping",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysTeamMemberMapping extends MappingBase<SysTeamMemberDTO, SysTeamMember> {


}

