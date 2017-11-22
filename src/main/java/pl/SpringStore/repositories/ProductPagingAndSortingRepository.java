package pl.SpringStore.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.SpringStore.models.ProductModel;

@Repository
public interface ProductPagingAndSortingRepository extends PagingAndSortingRepository<ProductModel, Integer> {
}
