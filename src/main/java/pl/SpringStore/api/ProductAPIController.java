package pl.SpringStore.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.SpringStore.models.ProductModel;
import pl.SpringStore.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductAPIController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    @ResponseBody
    public List<ProductModel> getAllProducts() {
        List<ProductModel> products = new ArrayList<>();
        for (ProductModel model : productService.findAll()) {
            products.add(model);
        }
        return products;
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public ProductModel getProductById (@PathVariable Integer id) {
        ProductModel product = productService.findByProductId(id);
        return product;

    }
}
