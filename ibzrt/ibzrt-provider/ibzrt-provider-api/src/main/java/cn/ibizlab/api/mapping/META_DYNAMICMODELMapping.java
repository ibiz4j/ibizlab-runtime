package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.disk.domain.META_DYNAMICMODEL;
import cn.ibizlab.api.dto.META_DYNAMICMODELDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiMETA_DYNAMICMODELMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface META_DYNAMICMODELMapping extends MappingBase<META_DYNAMICMODELDTO, META_DYNAMICMODEL> {


}

