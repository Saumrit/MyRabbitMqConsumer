package com.saumrit.myrabbitmq;

import com.saumrit.myrabbitmq.model.StudentTrackLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTrackingLogFRepository extends MongoRepository<StudentTrackLog,String>{
}
