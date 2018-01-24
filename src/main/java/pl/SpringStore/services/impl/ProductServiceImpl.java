package pl.SpringStore.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.SpringStore.forms.AddProductForm;
import pl.SpringStore.models.ProductModel;
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



    public List<ProductModel> products = new ArrayList<>();

    @Override
    public Iterable<ProductModel> findAll() {
        try {
            return productCRUDRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occurred during connection to database.");
            return Collections.emptyList();
        }
    }

    @Override
    public ProductModel findByProductId(int productId) {
        try {
            return productCRUDRepository.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Product with id={} does not exist");
        }
        return null;
    }

    @Override
    public List<ProductModel> findByName(String name) {
        List<ProductModel> productList = new ArrayList<>();
        for (ProductModel p : productCRUDRepository.findAll()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(p);
            }
        }
        return productList;
    }

    @Transactional
    @Override
    public Page<ProductModel> findAllPageable(Pageable pageable) {
        return productPagingAndSortingRepository.findAll(pageable);
    }

    @Override
    public void addProduct(ProductModel product) {
        ProductModel productModel = new ProductModel(addProductForm);
        productCRUDRepository.save(productModel);
    }

}
