package pl.SpringStore.models.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arabk on 31.10.2017.
 */
@Component
public class Cart {
    Long id;
    public String userOrder;
    public List<String> orderProd = new ArrayList<>();
//    public Cart() {
//        orderProd = Arrays.asList("");
//    }
private void add(String s) {
    orderProd.add(s);
}
}
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)