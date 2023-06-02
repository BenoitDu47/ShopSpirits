package fr.fms.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	Page<Article> findByDescriptionContains(String description, PageRequest pageRequest);
	@EntityGraph(attributePaths = "orderDetails")
	List<Article> findAll();
	void deleteById(Long id);

	Page<Article> findByCategory_IdAndDescriptionContains(Long categoryId, String kw, PageRequest of);
}
