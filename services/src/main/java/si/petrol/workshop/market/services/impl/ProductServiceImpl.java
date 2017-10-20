package si.petrol.workshop.market.services.impl;

import si.petrol.workshop.market.lib.Product;
import si.petrol.workshop.market.mappers.CustomerMapper;
import si.petrol.workshop.market.mappers.ProductMapper;
import si.petrol.workshop.market.models.db.CustomerEntity;
import si.petrol.workshop.market.models.db.ProductEntity;
import si.petrol.workshop.market.models.db.SupplierEntity;
import si.petrol.workshop.market.services.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Product findProduct(String productId) {

        ProductEntity prodEnt = em.find(ProductEntity.class, productId);

        return ProductMapper.toProduct(prodEnt);
    }

    @Override
    public List<Product> findProductsAll(Integer limit, Integer offset) {

        TypedQuery<ProductEntity> q1 = em.createNamedQuery("ProductEntitiy.findAll", ProductEntity.class);

        if(limit != null)
            q1.setMaxResults(limit);

        if(offset != null)
            q1.setFirstResult(offset);

        List<ProductEntity> prodEnt = q1.getResultList();

        return prodEnt.stream()
                .map(ProductMapper::toProduct)
                .collect(Collectors.toList());


    }

    @Override
    public Product addProduct(Product product) {

        ProductEntity prodEnt = ProductMapper.toProductEntity(product, new ProductEntity());

        if (prodEnt.getSupplier() != null) {
            SupplierEntity suplEnt = em.find(SupplierEntity.class, prodEnt.getSupplier().getId());

            if (suplEnt != null) {

                prodEnt.setSupplier(suplEnt);


            } else {
                prodEnt.setSupplier(null);
            }


        } else {
            SupplierEntity suplEnt = new SupplierEntity();
            suplEnt.setId(product.getSupplier().getId());
            suplEnt.setCompanyName("Petrol d.d.");

            ArrayList<ProductEntity> products = new ArrayList<ProductEntity>();
            products.add(prodEnt);
        }


        em.getTransaction().begin();
        em.persist(prodEnt);
        em.getTransaction().commit();

        return ProductMapper.toProduct(prodEnt);

    }

    @Override
    public void deleteProduct(String id) {


        ProductEntity prodEnt = em.find(ProductEntity.class, id);
        if (prodEnt != null) {
            em.getTransaction().begin();
            em.remove(prodEnt);
            em.getTransaction().commit();
        }
    }
}
