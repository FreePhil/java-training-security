package com.example.jdbcsecurity.controller;

import com.example.jdbcsecurity.model.Post;
import com.example.jdbcsecurity.model.PostDetail;
import com.example.jdbcsecurity.repository.AuthorRepository;
import com.example.jdbcsecurity.repository.PostRepository;
import com.example.jdbcsecurity.service.AuthenticationFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);
    private AuthenticationFetcher authFetcher;

    private final PostRepository posts;
    private final AuthorRepository authors;

    public PostController(PostRepository posts, AuthorRepository authors, AuthenticationFetcher authFetcher) {
        this.posts = posts;
        this.authors = authors;
        this.authFetcher = authFetcher;
    }

    @GetMapping
    public Iterable<Post> findAll() {
        logger.info("access user: {}", authFetcher.getUsername());
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id) {
        logger.info("access user: {}", authFetcher.getUsername());
        return posts.findById(id).orElse(null);
    }

    @GetMapping("/{id}/detail")
    @PreAuthorize("hasRole('ROLE_admin')")
    public PostDetail findDetailById(@PathVariable Integer id) {
        logger.info("access user: {}", authFetcher.getUsername());
        Post post = posts.findById(id).orElseThrow();
        return new PostDetail(post, authors.findById(post.getAuthor().getId()).orElse(null));
    }
}
