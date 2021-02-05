package com.company;

import java.util.List;

public class Product {
    private String name;
    private List<ContainedArticles> contain_articles;

    public Product() {
    }

    public Product(String name, List<ContainedArticles> contain_articles) {
        this.name = name;
        this.contain_articles = contain_articles;
    }

    public void print(){
        System.out.println(name);
        contain_articles.forEach( contained_article -> {
            contained_article.print();
        });
    }

    public String getName() {
        return name;
    }

    public List<ContainedArticles> getContain_articles() {
        return contain_articles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContain_articles(List<ContainedArticles> contain_articles) {
        this.contain_articles = contain_articles;
    }
}
