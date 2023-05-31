package fr.fms.service;

import fr.fms.entities.Article;
import fr.fms.entities.Cart;

public interface CartService {

    void addArticleToCart(Article article);

    void removeArticleFromCart(Article article);

    Cart getCart();
}