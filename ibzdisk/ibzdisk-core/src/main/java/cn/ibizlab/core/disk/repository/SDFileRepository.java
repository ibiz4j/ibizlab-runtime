package cn.ibizlab.core.disk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import cn.ibizlab.core.disk.domain.SDFile;
import org.springframework.stereotype.Repository;

@Repository
public interface SDFileRepository extends MongoRepository<SDFile, String>{

}

