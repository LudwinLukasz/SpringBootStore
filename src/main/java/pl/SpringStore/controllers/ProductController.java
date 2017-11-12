package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.SpringStore.repositories.CartRepository;
import pl.SpringStore.repositories.ProductCRUDRepository;
import pl.SpringStore.services.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"sessionName", "sessionIsLogged"})
@RequestMapping("/products")
public class ProductController {

    Map<String,String> sessionHash = new HashMap<>(  );

    @Autowired
    private ProductService productService;
    //@Autowired
    //CartRepository cart;

    //List<String> listcontrol= new ArrayList<>(  );

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/product")
    public String getProductById(@RequestParam(value = "productId") String productId, Model model) {
        model.addAttribute("product", productService.findByProductId(Integer.parseInt(productId)));
        return "product";
    }

    @GetMapping("")
    String search(@RequestParam(value = "q", required = false) String q, ModelMap modelMap) {
        if (q != null) {
            modelMap.addAttribute("products", productService.findByName(q));
        } else {
            modelMap.addAttribute("products", productService.findAll());
        }
        return "products";
    }
}
