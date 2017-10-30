package pl.SpringStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.SpringStore.models.Product;

import java.math.BigDecimal;

@Controller
public class ProductController {

    @RequestMapping("/products")
    public String list(Model model) {
        Product iPhone = new Product("P1234", "iPhone 5s", new BigDecimal(2200));
        iPhone.setDescription("Apple iPhone 5s, smarkfon z 4 calowym dotykowym wyświetlaczem o rozdzielczości 640x1136" +
                " oraz 8 megapikselowym aparatem");
        iPhone.setCategory("Smartfony");
        iPhone.setManufacturer("Apple");
        iPhone.setUnitsInStock(100);
        model.addAttribute("product", iPhone);
        return "products";
    }
}
