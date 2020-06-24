package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.api.dto.DictOptionDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DictOptionMapping extends MappingBase<DictOptionDTO, DictOption> {


}

