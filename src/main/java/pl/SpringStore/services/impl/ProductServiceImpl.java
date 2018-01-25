package pl.SpringStore.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.SpringStore.forms.AddProductForm;
import pl.SpringStore.models.Product;
import pl.SpringStore.repositories.ProductCRUDRepository;
import pl.SpringStore.repositories.ProductPagingAndSortingRepository;
import pl.SpringStore.services.ProductService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private AddProductForm addProductForm;

    @Autowired
    ProductCRUDRepository productCRUDRepository;

    @Autowired
    ProductPagingAndSortingRepository productPagingAndSortingRepository;



    public List<Product> products = new ArrayList<>();

    @Override
    public Iterable<Product> findAll() {
        try {
            return productCRUDRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occurred during connection to database.");
            return Collections.emptyList();
        }
    }

    @Override
    public Product findByProductId(int productId) {
        try {
            return productCRUDRepository.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Product with id={} does not exist");
        }
        return null;
    }

//    @Override
//    public List<Product> findByName(String name) {
//        List<Product> productList = new ArrayList<>();
//        for (Product p : productCRUDRepository.findAll()) {
//            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
//                productList.add(p);
//            }
//        }
//        return productList;
//    }


    @Override
    public Optional<Product> findByName(String name) {
        return productCRUDRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Product> findAllPageable(Pageable pageable) {
        return productPagingAndSortingRepository.findAll(pageable);
    }

    @Override
    public void addProduct(Product product) {
        productCRUDRepository.save(product);
    }

}
