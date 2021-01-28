package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.notify.domain.MsgBody;
import cn.ibizlab.api.dto.MsgBodyDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiMsgBodyMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MsgBodyMapping extends MappingBase<MsgBodyDTO, MsgBody> {


}

