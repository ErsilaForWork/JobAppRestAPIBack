package org.restjpa.service;

import org.restjpa.model.JobPost;
import org.restjpa.repo.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JobPostService {

    private JobPostRepo jobPostRepo;

    @Autowired
    public void setJobPostRepo(JobPostRepo jobPostRepo){
        this.jobPostRepo = jobPostRepo;
    }

    public void addPost(JobPost jobPost){
        jobPostRepo.save(jobPost);
    }

    public JobPost addPost( String  vacance, String descr, Integer exp, List<String> stack) throws NoSuchElementException {
        JobPost jobPost = new JobPost();

        jobPost.setPostVacance(vacance);
        jobPost.setPostDescription(descr);
        jobPost.setPostTechStack(stack);
        jobPost.setReqExperience(exp);

        jobPostRepo.save(jobPost);
        return jobPostRepo.findById(jobPost.getId()).orElse(new JobPost());
    }

    public List<JobPost> getPosts(){
        return jobPostRepo.findAll();
    }

    public Optional<JobPost> getPost(int postId) {
        return jobPostRepo.findById(postId);
    }

    public void updatePost(JobPost jobPost) {
        if(jobPostRepo.findById(jobPost.getId()).isPresent()){
            jobPostRepo.save(jobPost);
        }
    }

    public void delete(int postId) {
        jobPostRepo.deleteById(postId);
    }

    public List<JobPost> search(String keyword) {
        return jobPostRepo.findByPostTechStackContainingIgnoreCase(keyword);
    }
}
