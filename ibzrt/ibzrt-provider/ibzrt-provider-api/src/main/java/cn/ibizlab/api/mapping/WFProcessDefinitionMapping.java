package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.workflow.domain.WFProcessDefinition;
import cn.ibizlab.api.dto.WFProcessDefinitionDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiWFProcessDefinitionMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WFProcessDefinitionMapping extends MappingBase<WFProcessDefinitionDTO, WFProcessDefinition> {


}

