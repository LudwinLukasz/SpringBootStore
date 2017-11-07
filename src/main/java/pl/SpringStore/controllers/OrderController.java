package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.SpringStore.models.OrderModel;
import pl.SpringStore.repositories.CartRepository;
import pl.SpringStore.repositories.OrderCRUDRepository;


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
    CartRepository fakeOrder;
    @Autowired
    OrderCRUDRepository orderCRUDRepository;
    @Autowired
    OrderModel orderModel;

    List<String> orderList = new ArrayList<>();

    Map<String, String> sessionHash = new HashMap<>();

    @GetMapping("/order")
    // @ResponseBody
    public String order(HttpServletRequest request, ModelMap modelMap) {
        HttpSession session = request.getSession();

        modelMap.addAttribute( "imie", fakeOrder.userOrder );//session.getAttribute( "sessionName" ) );
        modelMap.addAttribute( "list", fakeOrder.orderProd );
        System.out.println( fakeOrder.orderProd );

        return "order";
    }

    @GetMapping("/order/{id}")
    public String remove(@PathVariable String id, ModelMap modelMap) {
        orderList.remove( id );
        orderList.remove( sessionHash.get( "sessionName" ) );
        fakeOrder.orderProd.remove( id );
        fakeOrder.userOrder = sessionHash.get( "sessionName" );
        System.out.println( fakeOrder.orderProd );


        return "order";
    }


    @GetMapping("/order/cart")
    public String order(ModelMap modelMap) {
        
        for (String t : fakeOrder.orderProd) {
            orderCRUDRepository.save( orderModel );
            System.out.println( orderModel);
        }
        modelMap.addAttribute( "order", orderModel );
        return "order/cart";


    }


}