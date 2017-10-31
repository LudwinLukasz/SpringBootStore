package pl.SpringStore.models.repositories;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arabk on 31.10.2017.
 */
@Component
public class Cart {
    Long id;
    public String userOrder;
    public List<String> orderProd = new ArrayList<>();
private void add(String s) {
    orderProd.add(s);
}
}
