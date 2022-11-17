package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.api.dto.WFProcessInstanceDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiWFProcessInstanceMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WFProcessInstanceMapping extends MappingBase<WFProcessInstanceDTO, WFProcessInstance> {


}
