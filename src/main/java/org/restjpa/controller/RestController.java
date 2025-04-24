package org.restjpa.controller;

import org.restjpa.model.JobPost;
import org.restjpa.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class RestController {

    private JobPostService service;

    @Autowired
    public void setService(JobPostService service){
        this.service = service;
    }

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        System.out.println("Get mapping jobPosts!");
        return service.getPosts();
    }

    @GetMapping("jobPost/{postId}")
    @ResponseBody
    public JobPost getJob(@PathVariable("postId") int postId){
        System.out.println("Get mapping jobPost/postId!");
        return service.getPost(postId).orElse(new JobPost());
    }

    @GetMapping("jobPost/keyword/{postVacance}")
    @ResponseBody
    public List<JobPost> search(@PathVariable("postVacance") String keyword){
        System.out.println("Get mapping jobPost/keyword!");
        return service.search(keyword);
    }

    @PostMapping("jobPost")
    @ResponseBody
    public void addJob(@RequestBody JobPost jobPost){
        System.out.println("Post mapping jobPost!");
        service.addPost(jobPost);
    }

    @PutMapping("jobPost")
    @ResponseBody
    public JobPost updateJob(@RequestBody JobPost jobPost){
        System.out.println("Put mapping jobPost!");
        service.updatePost(jobPost);
        return service.getPost(jobPost.getId()).orElse(new JobPost());
    }

    @DeleteMapping("jobPost/{postId}")
    @ResponseBody
    public String deleteJob(@PathVariable("postId") int postId){
        System.out.println("Delete mapping jobPost!");
        service.delete(postId);
        return "Deleted!";
    }
}
