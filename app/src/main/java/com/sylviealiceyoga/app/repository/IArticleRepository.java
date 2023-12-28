package com.sylviealiceyoga.app.repository;

import com.sylviealiceyoga.app.entity.Article;
import com.sylviealiceyoga.app.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticleRepository extends CrudRepository<Article, Long>
{
    List<Article> findByGroupId(Long groupId);
}
