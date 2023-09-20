package com.jeremia.restapiblog.service;

// author : Jere

import com.jeremia.restapiblog.entity.BlogPost;
import java.util.List;

public interface BlogPostService {

    // Post Data
    BlogPost saveBlog(BlogPost blogPost);

    // Get All
    List<BlogPost> fetchBlogPostList();

    //GetById
    BlogPost getById(Long blogId);

    // Update Data
    BlogPost updateBlogPost(BlogPost blogPost,
                          Long blogId);

    // Delete Data
    void deleteBlogPostById(Long blogId);
}
