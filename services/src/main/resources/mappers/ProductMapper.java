package mappers;

import si.petrol.workshop.market.lib.Product;
import si.petrol.workshop.market.lib.Supplier;
import si.petrol.workshop.market.models.db.ProductEntity;
import si.petrol.workshop.market.models.db.SupplierEntity;

public class ProductMapper {

    public static Product toProduct(ProductEntity productEntity) {

        if (productEntity == null) return null;

        Product product = new Product();
        product.setId(productEntity.getId());
        product.setCreatedAt(productEntity.getCreatedAt());
        product.setUpdatedAt(productEntity.getUpdatedAt());
        product.setTitle(productEntity.getTitle());
        product.setCurrency(productEntity.getCurrency());
        product.setPrice(productEntity.getPrice());
        product.setSupplier(toSupplier(productEntity.getSupplier()));

        return product;
    }

    public static ProductEntity toProductEntity(Product product, ProductEntity productEntity) {

        if (product == null || productEntity == null) return null;

        productEntity.setTitle(product.getTitle());
        productEntity.setCurrency(product.getCurrency());
        productEntity.setPrice(product.getPrice());

        if (product.getSupplier() != null && product.getSupplier().getId() != null) {

            SupplierEntity supplierEntity = new SupplierEntity();
            supplierEntity.setId(product.getSupplier().getId());

            productEntity.setSupplier(supplierEntity);
        }

        return productEntity;
    }

    public static Supplier toSupplier(SupplierEntity supplierEntity) {

        if (supplierEntity == null) return null;

        Supplier supplier = new Supplier();
        supplier.setId(supplierEntity.getId());
        supplier.setCreatedAt(supplierEntity.getCreatedAt());
        supplier.setUpdatedAt(supplierEntity.getUpdatedAt());
        supplier.setCompanyName(supplierEntity.getCompanyName());
        supplier.setStatus(supplierEntity.getStatus());

        return supplier;
    }
}
