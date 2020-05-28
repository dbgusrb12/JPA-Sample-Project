package com.hyungyu.webservice.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p " +
            "FROM Post p " +
            "ORDER BY p.id DESC")
    Stream<Post> findAllDesc();
}
