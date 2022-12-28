package com.croissantyoga.app.service;

import com.croissantyoga.app.entity.Article;

import java.util.List;

public interface IArticleService
{
    List<Article> findAll();
    Article getArticleById(long id);
    void deleteArticleById(long id);
    void deleteAll();
    Article updateArticle(long id, Article article);
    Article createArticle(Article article);
}
