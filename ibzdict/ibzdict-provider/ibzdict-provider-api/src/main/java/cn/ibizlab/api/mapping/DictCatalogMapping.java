package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.api.dto.DictCatalogDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},implementationName="apiDictCatalogMapping",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DictCatalogMapping extends MappingBase<DictCatalogDTO, DictCatalog> {


}

