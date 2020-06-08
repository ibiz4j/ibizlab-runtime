package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.api.dto.SysAppDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysAppMapping extends MappingBase<SysAppDTO, SysApp> {


}

