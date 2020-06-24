package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.task.domain.JobsLock;
import cn.ibizlab.api.dto.JobsLockDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface JobsLockMapping extends MappingBase<JobsLockDTO, JobsLock> {


}

