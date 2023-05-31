package fr.fms.web;

import fr.fms.entities.Article;
import fr.fms.entities.Cart;
import fr.fms.service.ArticleService;
import fr.fms.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ArticleService articleService;

    public CartController(CartService cartService, ArticleService articleService) {
        this.cartService = cartService;
        this.articleService = articleService;
    }

    @PostMapping("/add/{articleId}")
    public ResponseEntity<String> addToCart(@PathVariable Long articleId) {
        Article article = articleService.findById(articleId);
        if (article != null) {
            cartService.addArticleToCart(article);
            return ResponseEntity.ok("Article added to cart successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/remove/{articleId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long articleId) {
        Article article = articleService.findById(articleId);
        if (article != null) {
            cartService.removeArticleFromCart(article);
            return ResponseEntity.ok("Article removed from cart successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/view")
    public String viewCart(Model model) {
        Cart cart = cartService.getCart(); // Obtenez le panier du service de panier
        model.addAttribute("cart", cart); // Ajoutez le panier au modèle pour l'afficher dans la vue
        return "cart"; // Nom de la vue du panier (cart.html)
    }

}

