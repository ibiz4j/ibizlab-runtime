package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.uaa.domain.SysUserRole;
import cn.ibizlab.api.dto.SysUserRoleDTO;
import cn.ibizlab.util.domain.MappingBase;

@Mapper(componentModel = "spring", uses = {}, implementationName = "apiSysUserRoleMapping",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SysUserRoleMapping extends MappingBase<SysUserRoleDTO, SysUserRole> {


}

