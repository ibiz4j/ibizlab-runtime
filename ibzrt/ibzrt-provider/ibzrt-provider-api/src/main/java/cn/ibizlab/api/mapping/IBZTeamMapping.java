package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.ou.domain.IBZTeam;
import cn.ibizlab.api.dto.IBZTeamDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IBZTeamMapping extends MappingBase<IBZTeamDTO, IBZTeam> {


}

