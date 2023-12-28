package com.sylviealiceyoga.app.service;

import java.util.List;

import com.sylviealiceyoga.app.entity.User;
import com.sylviealiceyoga.app.repository.IArticleRepository;
import com.sylviealiceyoga.app.entity.Article;
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

    @Override
    public List<Article> findAllByUser(User user)
    {
        long groupId = user==null?1:user.getGroup().getId();
        List<Article> articles = repository.findByGroupId(groupId);
        for (long i=1; i<groupId; i++) {
            articles.addAll(repository.findByGroupId(i));
        }

        return articles;
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
