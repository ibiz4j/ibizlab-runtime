package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.api.dto.MsgOpenAccessDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiMsgOpenAccessMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MsgOpenAccessMapping extends MappingBase<MsgOpenAccessDTO, MsgOpenAccess> {


}
