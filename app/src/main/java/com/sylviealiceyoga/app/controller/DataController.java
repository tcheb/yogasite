package com.sylviealiceyoga.app.controller;

import com.sylviealiceyoga.app.auth.JwtTokenFilter;
import com.sylviealiceyoga.app.auth.JwtTokenUtil;
import com.sylviealiceyoga.app.entity.Article;
import com.sylviealiceyoga.app.entity.User;
import com.sylviealiceyoga.app.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DataController
{
    @Autowired
    private IArticleService articleService;

    @Autowired
    JwtTokenFilter jwtTokenFilter;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles(@RequestHeader(required=false) String authorization, @RequestParam(required = false) String title) {
        Object tmpUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) (tmpUser instanceof User?tmpUser:null);
        List<Article> articles = articleService.findAllByUser(user);

        return ResponseEntity.ok(articles);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") long id) {
        Article article = articleService.getArticleById(id);

        return Optional.ofNullable(article)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        article = articleService.createArticle(article);
        return Optional.ofNullable(article)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody Article article) {
        article = articleService.updateArticle(id, article);
        return Optional.ofNullable(article)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable("id") long id) {
        articleService.deleteArticleById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/articles")
    public ResponseEntity<HttpStatus> deleteAllArticles() {
        articleService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/articles/published")
    public ResponseEntity<List<Article>> findByPublished() {
        return null;
    }
}