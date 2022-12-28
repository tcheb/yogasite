package com.croissantyoga.app.repository;

import com.croissantyoga.app.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticleRepository extends CrudRepository<Article, Long>
{
}
