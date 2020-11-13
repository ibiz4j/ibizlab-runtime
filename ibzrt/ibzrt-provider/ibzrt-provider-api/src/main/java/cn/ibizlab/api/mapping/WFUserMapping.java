package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.workflow.domain.WFUser;
import cn.ibizlab.api.dto.WFUserDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiWFUserMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WFUserMapping extends MappingBase<WFUserDTO, WFUser> {


}

