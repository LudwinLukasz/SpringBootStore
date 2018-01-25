package pl.SpringStore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import pl.SpringStore.models.Product;
import pl.SpringStore.repositories.ProductCRUDRepository;
import pl.SpringStore.services.OrderService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by monik on 22.11.2017.
 */
@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductCRUDRepository productRepository;

    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product)) {

            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }


    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }


    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }


    public void checkout()  {
        Product product;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            // Refresh quantity for every product before checking
            product = productRepository.findOne(entry.getKey().getProductId());
          //  if (product.getUnitsInStock() < entry.getValue())
                entry.getKey().setUnitsInStock(product.getUnitsInStock() - entry.getValue());
        }
        productRepository.save(products.keySet());
        products.clear();
    }

    public void cleanUp(){
        products.clear();
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total = total.add(entry.getKey().getUnitPrice().multiply(new BigDecimal(entry.getValue())));
        }
        return total;
    }
}
