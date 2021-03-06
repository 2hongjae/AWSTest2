package com.test.awstest.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PostsRepository extends JpaRepository<Posts, Long> { // JpaRepository<Entity클래스, PK타입>


}
