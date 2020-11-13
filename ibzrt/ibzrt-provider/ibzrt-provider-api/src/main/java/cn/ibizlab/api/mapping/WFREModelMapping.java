package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.workflow.domain.WFREModel;
import cn.ibizlab.api.dto.WFREModelDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiWFREModelMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WFREModelMapping extends MappingBase<WFREModelDTO, WFREModel> {


}

