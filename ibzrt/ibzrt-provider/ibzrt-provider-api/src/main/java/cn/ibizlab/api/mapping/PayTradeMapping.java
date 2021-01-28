package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.pay.domain.PayTrade;
import cn.ibizlab.api.dto.PayTradeDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiPayTradeMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PayTradeMapping extends MappingBase<PayTradeDTO, PayTrade> {


}

