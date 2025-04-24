package org.restjpa.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "jobs_demo_jpa")
@SequenceGenerator(
        name = "seq",
        sequenceName = "job_seq_jpa",
        allocationSize = 1
)
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private int id;

    private String postVacance;
    private String postDescription;
    private Integer reqExperience;

    @ElementCollection
    @CollectionTable(
            name = "job_demo_jpa_techstack",
            joinColumns = @JoinColumn(name = "post_id")
    )
    @Column(name = "tech")
    private List<String> postTechStack;

    public JobPost(){
        postTechStack = new ArrayList<>();
    }

    public String getPostVacance() {
        return postVacance;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setPostVacance(String postVacance) {
        this.postVacance = postVacance;
    }

    public int getId() {
        return id;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public Integer getReqExperience() {
        return reqExperience;
    }

    public void setReqExperience(Integer reqExperience) {
        this.reqExperience = reqExperience;
    }

    public List<String> getPostTechStack() {
        return new ArrayList<>(postTechStack);
    }

    public void setPostTechStack(List<String> postTechStack) {
        this.postTechStack = postTechStack;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "id=" + id +
                ", postVacance='" + postVacance + '\'' +
                ", postDescription='" + postDescription + '\'' +
                ", reqExperience=" + reqExperience +
                ", postTechStack=" + postTechStack +
                '}';
    }
}
