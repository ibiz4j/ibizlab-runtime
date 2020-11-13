package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.notify.domain.MsgTemplate;
import cn.ibizlab.api.dto.MsgTemplateDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiMsgTemplateMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MsgTemplateMapping extends MappingBase<MsgTemplateDTO, MsgTemplate> {


}

