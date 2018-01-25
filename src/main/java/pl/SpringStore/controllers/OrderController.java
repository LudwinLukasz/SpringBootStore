package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.SpringStore.repositories.OrderCRUDRepository;
import pl.SpringStore.repositories.OrderProductCRUDRepository;
import pl.SpringStore.repositories.UsersRepository;
import pl.SpringStore.services.OrderModelProductService;
import pl.SpringStore.services.OrderService;
import pl.SpringStore.services.ProductService;

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