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
public class ProductController {

    Map<String,String> sessionHash = new HashMap<>(  );

    @Autowired
    private ProductService productService;
    //@Autowired
    //CartRepository cart;

    List<String> listcontrol= new ArrayList<>(  );

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

//    @RequestMapping(value = "/product", method = RequestMethod.GET)
//    public String getProductById(@RequestParam("productId") int productId, Model model) {
//        model.addAttribute("product", productRepository.getProductById(productId));
//        return "product";
//    }

    @GetMapping("/{productId}")
    public String getProductById(@RequestParam("productId") int productId, Model model) {
        model.addAttribute("products", productService.findByProductId(productId));
        return "product";
    }

    @GetMapping("/products")
    String search(@RequestParam(value = "q", required = false) String q, ModelMap modelMap) {
        if (q != null) {
            modelMap.addAttribute("products", productService.findByName(q));
        } else {
            modelMap.addAttribute("products", productService.findAll());
        }
        return "products";
    }
}
