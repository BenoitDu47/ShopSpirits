package fr.fms.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	Page<Article> findByDescriptionContains(String description, PageRequest pageRequest);
	public List<Article> findAll();
	void deleteById(Long id);
}
