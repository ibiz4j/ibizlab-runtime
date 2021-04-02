package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.notify.domain.MsgUserAccount;
import cn.ibizlab.api.dto.MsgUserAccountDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiMsgUserAccountMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MsgUserAccountMapping extends MappingBase<MsgUserAccountDTO, MsgUserAccount> {


}
