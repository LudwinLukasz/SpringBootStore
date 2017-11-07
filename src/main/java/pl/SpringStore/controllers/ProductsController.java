//package pl.SpringStore.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import pl.SpringStore.repositories.CartRepository;
//import pl.SpringStore.repositories.ProductCRUDRepository;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.*;
//
//@Controller
//@SessionAttributes({"sessionName", "sessionIsLogged"})
//public class ProductsController {
//
//    Map<String, String> sessionHash = new HashMap<>();
//
//    @Autowired
//    ProductCRUDRepository productCRUDRepository;
//    @Autowired
//    CartRepository fakeOrder;
//
//
//    List<String> listcontrol = new ArrayList<>();
//    List<String> who = new ArrayList<>();
//
//    @RequestMapping("/addproduct")
//    public String add(HttpServletRequest request, ModelMap modelMap) {
//
//        modelMap.addAttribute("products", productCRUDRepository.findAll());
//        HttpSession session = request.getSession();
//        //session.getAttribute("sessionName");
//        Enumeration<String> attributeNames = session.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            String param = attributeNames.nextElement();
//            sessionHash.put(param, session.getAttribute(param).toString());
//        }
//        return "productsList";
//    }
//
//    @RequestMapping("/showproductslist")
//    public String list(HttpServletRequest request, ModelMap modelMap) {
//        modelMap.addAttribute("products", productCRUDRepository.findAll());
//        return "productsList";
//    }
//
//
//    @GetMapping("/prod/{id}")
//    // @ResponseBody
//    public String index(@PathVariable String id, ModelMap modelMap) {
//        // modelMap.addAttribute("name", id);
//        listcontrol.add(id);
//        listcontrol.add(sessionHash.get("sessionName"));
//        System.out.println(listcontrol);
//        fakeOrder.orderProd.add(id);
//        fakeOrder.userOrder = sessionHash.get("sessionName");
//        // modelMap.addAttribute( "list",fakeOrder.orderProd.add( id ) );
//        return "redirect:/showproductslist";
//    }
//
//
//}