package com.jeremia.restapiblog.service;

// author : jere

import com.jeremia.restapiblog.entity.BlogPost;
import com.jeremia.restapiblog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class BlogPostImpl implements BlogPostService{

    @Autowired
    private BlogRepository blogRepository;

    // Post
    @Override
    public BlogPost saveBlog(BlogPost blogPost) {
        return blogRepository.save(blogPost);
    }

    // Get All
    @Override
    public List<BlogPost> fetchBlogPostList() {
        return (List<BlogPost>)
                blogRepository.findAll();
    }

    // GetById
    @Override
    public BlogPost getById(Long blogId) {
        BlogPost data
                = blogRepository.findById(blogId)
                .get();
        if(data != null){
            BlogPost blog = new BlogPost();
            blog.setBlogId(data.getBlogId());
            blog.setBlogTitle(data.getBlogTitle());
            blog.setBlogBody(data.getBlogBody());
            blog.setBlogAuthor(data.getBlogAuthor());

            return blog;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"DATA TIDAK DITEMUKAN");
        }
    }

    // Update byId
    @Override
    public BlogPost updateBlogPost(BlogPost blogPost, Long blogId) {
        BlogPost data
                = blogRepository.findById(blogId)
                .get();

        if (Objects.nonNull(blogPost.getBlogTitle())
                && !"".equalsIgnoreCase(
                blogPost.getBlogTitle())) {
            data.setBlogTitle(
                    blogPost.getBlogTitle());
        }

        if (Objects.nonNull(
                blogPost.getBlogBody())
                && !"".equalsIgnoreCase(
                blogPost.getBlogBody())) {
            data.setBlogBody(
                    blogPost.getBlogBody());
        }

        if (Objects.nonNull(blogPost.getBlogAuthor())
                && !"".equalsIgnoreCase(
                blogPost.getBlogAuthor())) {
            data.setBlogAuthor(
                    blogPost.getBlogAuthor());
        }

        return blogRepository.save(data);
    }

    //Delete byId
    @Override
    public void deleteBlogPostById(Long blogId) {
        blogRepository.deleteById(blogId);
    }
}
