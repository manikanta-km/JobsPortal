package com.example.JobSearchPortal.repo;

import com.example.JobSearchPortal.model.Job;
import com.example.JobSearchPortal.model.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {

    List<Job> findByJobLocation(String location);

    List<Job> findByJobType(Type type);

    List<Job> findByJobSalaryGreaterThan(double salary);

    List<Job> findByCompanyName(String name);

    @Modifying
    @Query(value = "UPDATE JOB SET JOB_SALARY = (JOB_SALARY + JOB_SALARY*(:hike)) WHERE JOB_TYPE = :jobType", nativeQuery = true)
    void updateJobByType(float hike, String jobType);

    @Modifying
    @Query(value = "UPDATE JOB SET JOB_SALARY = (JOB_SALARY + JOB_SALARY*(:hike)) WHERE JOB_LOCATION = :jobLocation", nativeQuery = true)
    void updateJobByLocation(float hike, String jobLocation);
}
