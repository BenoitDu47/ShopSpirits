package fr.fms.service;

import fr.fms.entities.Article;
import fr.fms.entities.Cart;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {


    @Override
    public void addArticleToCart(Article article) {

    }

    @Override
    public void removeArticleFromCart(Article article) {

    }

    @Override
    public Cart getCart() {
        return null;
    }
}