package pl.SpringStore.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.Product;

@Repository
public interface ProductPagingAndSortingRepository extends PagingAndSortingRepository<Product, Integer> {
}
