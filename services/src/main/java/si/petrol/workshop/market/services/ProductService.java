package si.petrol.workshop.market.services;

import si.petrol.workshop.market.lib.Product;
import si.petrol.workshop.market.services.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ProductService {

    Product findProduct(String productId);

    List<Product> findProductsAll(Integer limit, Integer offset);

    Product addProduct(Product product) throws ResourceNotFoundException;

    void deleteProduct(String id);

}
