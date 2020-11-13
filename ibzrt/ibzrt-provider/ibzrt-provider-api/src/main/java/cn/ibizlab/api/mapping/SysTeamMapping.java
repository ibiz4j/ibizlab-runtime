package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.ou.domain.SysTeam;
import cn.ibizlab.api.dto.SysTeamDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiSysTeamMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysTeamMapping extends MappingBase<SysTeamDTO, SysTeam> {


}

