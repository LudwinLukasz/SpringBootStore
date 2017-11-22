package pl.SpringStore.services;

import org.springframework.stereotype.Service;
import pl.SpringStore.models.CartModel;

@Service
public interface CartService {
    CartModel create(CartModel cart);
    CartModel read(CartModel cart);
    void update(int cartId, CartModel cart);
    void delete(int cartId);
}
