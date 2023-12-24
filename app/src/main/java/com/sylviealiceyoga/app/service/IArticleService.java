package com.sylviealiceyoga.app.service;

import com.sylviealiceyoga.app.entity.Article;

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
