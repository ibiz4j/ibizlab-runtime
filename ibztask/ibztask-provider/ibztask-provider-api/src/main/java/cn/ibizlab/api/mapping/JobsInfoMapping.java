package cn.ibizlab.api.mapping;

import org.mapstruct.*;
import cn.ibizlab.core.task.domain.JobsInfo;
import cn.ibizlab.api.dto.JobsInfoDTO;
import cn.ibizlab.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},implementationName="apiJobsInfoMapping",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface JobsInfoMapping extends MappingBase<JobsInfoDTO, JobsInfo> {


}

