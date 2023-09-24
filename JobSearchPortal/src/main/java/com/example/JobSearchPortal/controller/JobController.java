package com.example.JobSearchPortal.controller;

import com.example.JobSearchPortal.model.Job;
import com.example.JobSearchPortal.model.Type;
import com.example.JobSearchPortal.services.JobServices;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobServices jobServices;

    @PostMapping("job")
    public String addJob(@RequestBody List<Job> newJob){
        return jobServices.addJob(newJob);
    }

    @GetMapping("job/id/{id}")
    public List<Job> getJob(@PathVariable Long id){
        return jobServices.getJobById(id);
    }

    @GetMapping("jobs")
    public List<Job> getAllJobs(){
        return jobServices.getAllJobs();
    }

    @PutMapping("job/id/{id}/location/{location}")
    public String updateJobInfo(@PathVariable Long id, @PathVariable String location){
        return jobServices.updateJobInfo(id,location);
    }

    @DeleteMapping("job/id{id}")
    public String deleteJob(@PathVariable Long id){
        return jobServices.deleteJob(id);
    }

    @GetMapping("job/location/{location}")
    public List<Job> getJobByLocation(@PathVariable String location){
        return jobServices.getJobByLocation(location);
    }

    @GetMapping("job/type/{type}")
    public List<Job> getJobByType(@PathVariable Type type){
        return jobServices.getJobByType(type);
    }

    @GetMapping("job/salary/{salary}")
    public List<Job> getJobsAboveSalary(@PathVariable double salary){
        return jobServices.getJobsAboveSalary(salary);
    }

    @GetMapping("job/companyName/{companyName}")
    public List<Job> getJobByCompany(@PathVariable String cname){
        return jobServices.getJobByCompany(cname);
    }

    @PutMapping("job/hike/{hike}/type/{jobType}")
    public String updateJobByType(@PathVariable float hike, @PathVariable Type jobType){
        return jobServices.updateJobByType(hike,jobType);
    }

    @PutMapping("job/hike/{hike}/location/{location}")
    public String updateJobByLocation(@PathVariable float hike, @PathVariable String location){
        return jobServices.updateJobByLocation(hike,location);
    }

}
