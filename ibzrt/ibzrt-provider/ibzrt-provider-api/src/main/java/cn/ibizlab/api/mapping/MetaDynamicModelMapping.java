package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.disk.domain.MetaDynamicModel;
import cn.ibizlab.api.dto.MetaDynamicModelDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiMetaDynamicModelMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MetaDynamicModelMapping extends MappingBase<MetaDynamicModelDTO, MetaDynamicModel> {


}
