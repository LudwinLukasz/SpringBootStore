package pl.SpringStore.repositories;

import org.springframework.stereotype.Repository;
import pl.SpringStore.models.CartModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface CartRepositoryInterface {
    CartModel create(CartModel cart);
    CartModel read(CartModel cart);
    void update(int cartId, CartModel cart);
    void delete(int cartId);
}
