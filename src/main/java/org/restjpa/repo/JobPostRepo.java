package org.restjpa.repo;

import org.restjpa.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobPostRepo extends JpaRepository<JobPost,Integer> {

    @Query("select post from JobPost post join post.postTechStack t where " +
            "lower(post.postVacance) like lower(concat('%',:kw,'%') ) or " +
            "lower(post.postDescription) like lower(concat('%',:kw,'%') ) or " +
            "lower(t) like lower(concat('%',:kw,'%'))"
    )
    List<JobPost> findByPostTechStackContainingIgnoreCase(@Param("kw") String keyword);

}