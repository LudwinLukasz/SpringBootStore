package pl.SpringStore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.SpringStore.models.CartModel;
import pl.SpringStore.repositories.CartRepository;
import pl.SpringStore.repositories.CartRepositoryInterface;
import pl.SpringStore.services.CartService;

public class CartServiceImpl implements CartService {
    @Autowired
    CartRepositoryInterface cartRepository;

    @Override
    public CartModel create(CartModel cart) {
        return cartRepository.create(cart);
    }

    @Override
    public CartModel read(CartModel cart) {
        return cartRepository.read(cart);
    }

    @Override
    public void update(int cartId, CartModel cart) {
        cartRepository.update(cartId, cart);
    }

    @Override
    public void delete(int cartId) {
        cartRepository.delete(cartId);
    }
}
