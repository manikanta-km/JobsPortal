package com.example.JobSearchPortal.services;

import com.example.JobSearchPortal.model.Job;
import com.example.JobSearchPortal.model.Type;
import com.example.JobSearchPortal.repo.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JobServices {
    @Autowired
    IJobRepo iJobRepo;

    public String addJob(List<Job> newJob){
        iJobRepo.saveAll(newJob);
        return "New Job Added in Portal";
    }
    public List<Job> getJobById(Long id){
        return (List<Job>) iJobRepo.findAllById(Collections.singleton(id));
    }
    public List<Job> getAllJobs(){
        return (List<Job>) iJobRepo.findAll();
    }

    public String updateJobInfo(Long id,String location){
        Job cJob = iJobRepo.findById(id).orElse(null);
        if(cJob != null){
            cJob.setJobLocation(location);
            iJobRepo.save(cJob);
            return "Job Info Updated";
        }
        else{
            return "Job Not Found";
        }
    }

    public String deleteJob(Long id){
        iJobRepo.deleteById(id);
        return "Job Deleted";
    }

    public List<Job> getJobByLocation(String location){
        return iJobRepo.findByJobLocation(location);
    }

    public List<Job> getJobByType(Type type){
        return iJobRepo.findByJobType(type);
    }

    public List<Job> getJobsAboveSalary(double salary){
        return iJobRepo.findByJobSalaryGreaterThan(salary);
    }

    public List<Job> getJobByCompany(String cname){
        return iJobRepo.findByCompanyName(cname);
    }

    @Transactional
    public String updateJobByType(float hike, Type jobType){
        iJobRepo.updateJobByType(hike,jobType.name());
        return "updated";
    }

    @Transactional
    public String updateJobByLocation(float hike, String jobLocation){
        iJobRepo.updateJobByLocation(hike,jobLocation);
        return "updated";
    }



}
