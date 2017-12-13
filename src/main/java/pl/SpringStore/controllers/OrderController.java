package pl.SpringStore.controllers;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.SpringStore.models.OrderModel;
import pl.SpringStore.models.OrderModelProduct;
import pl.SpringStore.models.ProductModel;
import pl.SpringStore.models.Users;
import pl.SpringStore.repositories.OrderCRUDRepository;
import pl.SpringStore.repositories.OrderProductCRUDRepository;
import pl.SpringStore.repositories.UsersRepository;
import pl.SpringStore.services.EmailSender;
import pl.SpringStore.services.OrderModelProductService;
import pl.SpringStore.services.OrderService;
import pl.SpringStore.services.ProductService;

import java.math.BigDecimal;
import java.util.*;

@Controller
//@SessionAttributes({"sessionName","sessionIsLogged"})
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderCRUDRepository orderCRUDRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    OrderProductCRUDRepository orderProductCRUDRepository;

    @Autowired
    OrderModelProductService orderModelProductService;

    @GetMapping("/order")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("products", orderService.getProductsInCart());
        modelAndView.addObject("total", orderService.getTotal().toString());
        modelAndView.addObject("test", orderService.getProductsInCart().entrySet().size());
        return modelAndView;
    }

    @PostMapping("/shoppingCart/addProduct")
    //@GetMapping("/shoppingCart/addProduct/{productId}")
    public ModelAndView addProductToCart(@RequestParam(value = "productId") Integer productId) {
        orderService.addProduct(productService.findByProductId(productId));
        return shoppingCart();
    }

    @PostMapping("/shoppingCart/removeProduct")
//    @GetMapping("/order/removeProduct/{productId}")
    public ModelAndView removeProductFromCart(@RequestParam(value = "productId") Integer productId) {
        orderService.removeProduct(productService.findByProductId(productId));
        return shoppingCart();
    }
//
    @GetMapping("/order/checkout")
    public ModelAndView checkout(){
        orderModelProductService.saveOrder();
        orderService.cleanUp();
        return shoppingCart();
    }
//
}