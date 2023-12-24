package com.sylviealiceyoga.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "Groups")
public class Group
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    //@OneToMany(mappedBy = "group")
    //private List<Article> articles;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    //public List<Article> getArticles()
    //{
    //    return articles;
    //}
}
