package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.SpringStore.models.Product;
import pl.SpringStore.models.repositories.Cart;
import pl.SpringStore.models.repositories.FakeProductsRepo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

@Controller
@SessionAttributes({"sessionName","sessionIsLogged"})
public class ProductsController {

    Map<String,String> sessionHash = new HashMap<>();

   @Autowired
    FakeProductsRepo fakeProductsRepo;
    @Autowired
    Cart cart;

    List<String> idsList = new ArrayList<>();
    Map<String,String> cartHash = new HashMap<>();
    List<String> who = new ArrayList<>();

    @RequestMapping("/addproduct")
        public String add(HttpServletRequest request, ModelMap modelMap) {
            Product iPhone = new Product("P1234", "iPhone 5s", new BigDecimal(2200));
            iPhone.setDescription("Apple iPhone 5s, smarkfon z 4 calowym dotykowym wyświetlaczem o rozdzielczości 640x1136" +
                    " oraz 8 megapikselowym aparatem");
            iPhone.setCategory("Smartfony");
            iPhone.setManufacturer("Apple");
            iPhone.setUnitsInStock(100);

            Product iPhone2 = new Product("P1235", "iPhone 5s", new BigDecimal(2200));
            iPhone.setDescription("blalbalalalalal");
            iPhone.setCategory("Smartfony");
            iPhone.setManufacturer("Apple");
            iPhone.setUnitsInStock(200);
            fakeProductsRepo.add(iPhone);
            fakeProductsRepo.add(iPhone2);
            modelMap.addAttribute("products", fakeProductsRepo.getProducts());
        HttpSession session=request.getSession();
//session.getAttribute("sessionName");
Enumeration<String> attributeNames = session.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String param = attributeNames.nextElement();

            sessionHash.put(param, session.getAttribute(param).toString());
        }

        return "productsList";
        }

    @RequestMapping("/showproductslist")
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("products", fakeProductsRepo.getProducts());
        return "productsList";
    }


    @GetMapping("/prod/{id}")
   // @ResponseBody
    public String index(@PathVariable String id, ModelMap modelMap){
       // modelMap.addAttribute("name", id);
        String sessionN = sessionHash.get("sessionName");
        idsList.add(sessionN);
        System.out.println(idsList);
//        if (idsList.size()>1) {
//            if (idsList.get(idsList.size()-2).equals(sessionN)) {
//                cart.orderProd.add(id);
//            } else {
//
//                cart.orderProd.add(id);
//            }
//        } else {
//            cart.orderProd.add(id);
//        }
        cart.orderProd.add(id);
        cart.userOrder=sessionHash.get("sessionName");
        return "redirect:/showproductslist";
    }

    @GetMapping("/order")
    // @ResponseBody
    public String order(HttpServletRequest request, ModelMap modelMap) {
        HttpSession session=request.getSession();
        modelMap.addAttribute( "list" ,cart.orderProd);
       // modelMap.addAttribute( "list" ,"alamakota");
        modelMap.addAttribute("imie",session.getAttribute("sessionName"));
        return "test";
    }
}
