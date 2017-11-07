package pl.SpringStore.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by monik on 04.11.2017.
 */

@Repository
@Component
    public class CartRepository {
        Long cartId;
        public String userOrder;
        public List<String> orderProd = new ArrayList<String>();
        public int account;

        public BigDecimal totalprice;

        private void add(String id){
            orderProd.add( id );// dodawanie do koszyka
        }

        private void remove(String product){
            orderProd.remove( product ); // usuwanie z koszyka
        }
        private void setAccount(){

        }


    }

