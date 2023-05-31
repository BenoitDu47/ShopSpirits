package fr.fms.service;

import fr.fms.entities.Article;

import java.util.List;

public interface ArticleService {
    Article findById(Long id);
    List<Article> getAllArticles();
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(Long id);
}