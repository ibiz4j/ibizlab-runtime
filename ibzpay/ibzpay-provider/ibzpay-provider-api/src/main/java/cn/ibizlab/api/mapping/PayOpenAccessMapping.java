package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.pay.domain.PayOpenAccess;
import cn.ibizlab.api.dto.PayOpenAccessDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},implementationName="apiPayOpenAccessMapping",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PayOpenAccessMapping extends MappingBase<PayOpenAccessDTO, PayOpenAccess> {


}

