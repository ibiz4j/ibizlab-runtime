package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.api.dto.SDFileDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SDFileMapping extends MappingBase<SDFileDTO, SDFile> {


}

