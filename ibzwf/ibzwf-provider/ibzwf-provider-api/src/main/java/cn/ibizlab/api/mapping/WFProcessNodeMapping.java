package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.api.dto.WFProcessNodeDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiWFProcessNodeMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WFProcessNodeMapping extends MappingBase<WFProcessNodeDTO, WFProcessNode> {


}
