package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.SpringStore.models.Pager;
import pl.SpringStore.models.ProductModel;
import pl.SpringStore.services.ProductService;
import pl.SpringStore.services.impl.ProductServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    Map<String,String> sessionHash = new HashMap<>(  );

    private static final int BUTTONS_TO_SHOW = 6;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 6;
    private static final int[] PAGE_SIZES = {6, 9, 12};

    @Autowired
    private ProductServiceImpl productServiceImpl;

    private ProductService productService;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/")
    public ModelAndView showProductPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam(value = "q", required = false) String q, ModelMap modelMap) {

        ModelAndView modelAndView = new ModelAndView("products");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<ProductModel> products = productServiceImpl.findAllPageable(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);


        modelAndView.addObject("pager", pager);
        if (q != null) {
            modelAndView.addObject("products", productServiceImpl.findByName(q));

        } else {
            modelAndView.addObject("selectedPageSize", evalPageSize);
            modelAndView.addObject("pageSizes", PAGE_SIZES);
            modelAndView.addObject("products", products);
        }
        return modelAndView;
    }

    @GetMapping("/product")
    public String getProductById(@RequestParam(value = "productId") String productId, Model model) {
        model.addAttribute("product", productServiceImpl.findByProductId(Integer.parseInt(productId)));
        return "product";
    }

}
