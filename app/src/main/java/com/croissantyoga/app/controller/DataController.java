package com.croissantyoga.app.controller;

import com.croissantyoga.app.db.Article;
import com.croissantyoga.app.db.Group;
import com.croissantyoga.app.db.IArticleService;
import com.croissantyoga.app.db.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private IGroupService groupService;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles(@RequestParam(required = false) String title) {
        List<Article> articles = (List<Article>) articleService.findAll();

        return ResponseEntity.ok(articles);
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getAllGroups(@RequestParam(required = false) String name) {
        List<Group> groups = (List<Group>) groupService.findAll();

        return ResponseEntity.ok(groups);
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