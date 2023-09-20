package com.jeremia.restapiblog.controller;

// author : jere

import com.jeremia.restapiblog.entity.BlogPost;
import com.jeremia.restapiblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    // Post
    @PostMapping("api/blogs")
    public BlogPost saveBlogPost(
             @RequestBody BlogPost blogPost)
    {
        return blogPostService.saveBlog(blogPost);
    }

    // Get All
    @GetMapping("api/blogs")
    public List<BlogPost> fetchBlogPostList()
    {
        return blogPostService.fetchBlogPostList();
    }

    // Get ById
    @GetMapping("api/blogs/{id}")
    public BlogPost getById(@PathVariable("id") Long blogId){
        return blogPostService.getById(
                blogId);
    }

    // Update byId
    @PutMapping("api/blogs/{id}")
    public BlogPost
    updateBlogPost(@RequestBody BlogPost blogPost,
                     @PathVariable("id") Long blogId)
    {
        return blogPostService.updateBlogPost(
                blogPost, blogId);
    }

    // Delete
    @DeleteMapping("api/blogs/{id}")
    public String deleteBlogPostById(@PathVariable("id")
                                    Long blogId)
    {
        blogPostService.deleteBlogPostById(
                blogId);
        return "Deleted Successfully";
    }
}
