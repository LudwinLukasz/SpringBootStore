package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.SpringStore.models.OrderModel;
import pl.SpringStore.models.ProductModel;
import pl.SpringStore.repositories.CartRepository;
import pl.SpringStore.repositories.OrderCRUDRepository;
import pl.SpringStore.services.ProductService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by monik on 31.10.2017.
 */
@Controller
@SessionAttributes({"sessionName","sessionIsLogged"})
public class OrderController {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderCRUDRepository orderCRUDRepository;
    @Autowired
    OrderModel orderModel;

    @Autowired
    ProductService productService;

    List<String> orderList = new ArrayList<>();

    Map<String, String> sessionHash = new HashMap<>();

    @GetMapping("/order")
    // @ResponseBody
    public String order(HttpServletRequest request,HttpSession session, ModelMap modelMap) {
        session = request.getSession();

        modelMap.addAttribute( "imie", cartRepository.userOrder );//session.getAttribute( "sessionName" ) );
        modelMap.addAttribute( "list", cartRepository.orderProd );
        System.out.println( "Order " + cartRepository.orderProd );

        return "order";
    }

    @GetMapping("/order/{id}")
    public String remove(@PathVariable String id, ModelMap modelMap) {
        orderList.remove( productService.findByProductId(Integer.parseInt(id )) );
        orderList.remove( sessionHash.get( "sessionName" ) );
        System.out.println(productService.findByProductId( Integer.parseInt(id )));
        System.out.println(cartRepository.removeById(( Integer.parseInt(id ))));
        cartRepository.userOrder = sessionHash.get( "sessionName" );
        System.out.println( "Remove " + cartRepository.orderProd );


        return "redirect:/order";
    }


    @GetMapping("/order/cart")
    public String order(ModelMap modelMap) {

        for (ProductModel t : cartRepository.orderProd) {
            orderCRUDRepository.save( orderModel );
            System.out.println( orderModel);
        }
        modelMap.addAttribute( "order", orderModel );
        return "order/cart";


    }


}