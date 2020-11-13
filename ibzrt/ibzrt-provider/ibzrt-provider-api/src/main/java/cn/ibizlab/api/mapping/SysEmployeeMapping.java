package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.api.dto.SysEmployeeDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiSysEmployeeMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysEmployeeMapping extends MappingBase<SysEmployeeDTO, SysEmployee> {


}

