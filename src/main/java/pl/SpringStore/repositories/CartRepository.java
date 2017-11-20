package pl.SpringStore.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.ProductModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by monik on 04.11.2017.
 */

//@Repository
@Component
public class CartRepository {
    Long cartId;
    public String userOrder;
    public List<ProductModel> orderProd = new ArrayList<>();
    public int account;

    public BigDecimal totalprice;

    private void add(ProductModel id){
        orderProd.add( id );// dodawanie do koszyka
    }

    private void remove(ProductModel product){
        orderProd.remove( product ); // usuwanie z koszyka
    }
    private void setAccount(){

    }

    public boolean removeById(Integer id){
        for(ProductModel productModel : orderProd){
            if(productModel.getProductId()==id){
                return orderProd.remove( productModel );
            }
        }
        return false;
    }

}

