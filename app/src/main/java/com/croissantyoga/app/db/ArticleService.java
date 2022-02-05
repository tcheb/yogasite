package com.croissantyoga.app.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class ArticleService implements IArticleService
{
    @Autowired
    private IArticleRepository repository;

    @Override
    public List<Article> findAll()
    {
        return (List<Article>) repository.findAll();
    }

    @Nullable
    @Override
    public Article getArticleById(long id)
    {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteArticleById(long id)
    {
        repository.deleteById(id);
        return;
    }

    @Override
    public void deleteAll()
    {
        repository.deleteAll();
        return;
    }

    @Nullable
    @Override
    public Article updateArticle(long id, Article article)
    {
        Article newArticle = repository.findById(id).orElse(null);
        if (newArticle == null)
        {
            return null;
        }

        newArticle.setText(article.getText());
        newArticle.setDescription(article.getDescription());
        newArticle.setImage(article.getImage());
        newArticle.setTitle(article.getTitle());
        newArticle.setPublished(article.isPublished());
        newArticle.setLang(article.getLang());
        return repository.save(newArticle);
    }

    @Override
    public Article createArticle(Article article)
    {
        return repository.save(article);
    }
}
