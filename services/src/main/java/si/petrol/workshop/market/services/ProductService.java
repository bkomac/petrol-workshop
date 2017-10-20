package si.petrol.workshop.market.services;

import si.petrol.workshop.market.lib.Product;

import java.util.List;

public interface ProductService {

    Product findProduct(String productId);

    List<Product> findProductsAll();

    Product addProduct(Product product);

    void deleteProduct(String id);

}
