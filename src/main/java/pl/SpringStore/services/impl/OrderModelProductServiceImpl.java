package pl.SpringStore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import pl.SpringStore.models.OrderModel;
import pl.SpringStore.models.OrderModelProduct;
import pl.SpringStore.models.ProductModel;
import pl.SpringStore.models.Users;
import pl.SpringStore.repositories.OrderCRUDRepository;
import pl.SpringStore.repositories.OrderProductCRUDRepository;
import pl.SpringStore.repositories.ProductCRUDRepository;
import pl.SpringStore.repositories.UsersRepository;
import pl.SpringStore.services.OrderModelProductService;
import pl.SpringStore.services.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by arabk on 10.12.2017.
 */
@Service
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class OrderModelProductServiceImpl implements OrderModelProductService {

    @Autowired
    private OrderCRUDRepository orderCRUDRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private OrderProductCRUDRepository orderProductCRUDRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductCRUDRepository productCRUDRepository;

    public void saveOrder() {
        Map<ProductModel, Integer> productsInCart = orderService.getProductsInCart();
        Set<ProductModel> productsInCartSet = productsInCart.keySet();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // if (!(authentication instanceof AnonymousAuthenticationToken)) {
        String currentUserName = authentication.getName();
        //  }
            Users currentUser = usersRepository.findByLogin(currentUserName).get();
        orderCRUDRepository.save(new OrderModel(4,productsInCartSet,currentUser));
        updateProductsQuantity();
    }

    private void updateProductsQuantity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // if (!(authentication instanceof AnonymousAuthenticationToken)) {
        String currentUserName = authentication.getName();
        //  }
        Users currentUser = usersRepository.findByLogin(currentUserName).get();
        List<OrderModel> currentUserOrders = orderCRUDRepository.findByUsers(currentUser);

        List<Integer> ordersIdList = currentUserOrders.stream()
                .map(s -> s.getId())
                .sorted()
                .collect(Collectors.toList());

        Integer currentOrderId = ordersIdList.get(ordersIdList.size()-1);

        List<OrderModelProduct> currentOrderProductList = orderProductCRUDRepository.findByOrderId(currentOrderId);

        Map<ProductModel, Integer> productsInCart = orderService.getProductsInCart();

        Map<Integer,Integer> productIdQuantityMap = new HashMap<>();

        for (Map.Entry<ProductModel, Integer> entry : productsInCart.entrySet()) {
            productIdQuantityMap.put(entry.getKey().getProductId(),entry.getValue());
        }

        for (OrderModelProduct omp: currentOrderProductList
             ) {
            omp.setQuantity(productIdQuantityMap.get(omp.getProductId()));
            System.out.println(productIdQuantityMap.get(omp.getProductId()));
            System.out.println(omp.getQuantity());
            System.out.println(omp.getId());
            Integer q = omp.getQuantity();
            Long units = productCRUDRepository.findByProductId(omp.getProductId()).getUnitsInStock();
            units = units - omp.getQuantity();
            productCRUDRepository.setUnitsInStockById(units,omp.getProductId());
        }
    }

}
