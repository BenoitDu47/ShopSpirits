package fr.fms.web;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "keyword", defaultValue = "") String kw,
                        @RequestParam(name = "categoryId", required = false) Long categoryId) {

        Page<Article> articles;

        if (categoryId != null) {
            articles = articleRepository.findByCategory_IdAndDescriptionContains(categoryId, kw, PageRequest.of(page, 5));
        } else {
            articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 5));
        }

        model.addAttribute("listArticle", articles.getContent());
        model.addAttribute("pages", new int[articles.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategoryId", categoryId);

        return "articles";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id,
                         @RequestParam("page") int page,
                         @RequestParam("keyword") String keyword) {
        articleRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/article")
    public String article(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("article", new Article());
        return "article";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Category> categories = categoryRepository.findAll();
            model.addAttribute("categories", categories);
            return "article";
        }
        articleRepository.save(article);
        return "redirect:/index";
    }

    @GetMapping("/edit")
    public String editArticle(Model model, @RequestParam("id") Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid article Id: " + id));

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("article", article);
        return "article";
    }


}
