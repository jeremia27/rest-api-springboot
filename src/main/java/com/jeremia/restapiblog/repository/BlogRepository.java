package com.jeremia.restapiblog.repository;

// author : Jere

import com.jeremia.restapiblog.entity.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<BlogPost, Long> {

}
