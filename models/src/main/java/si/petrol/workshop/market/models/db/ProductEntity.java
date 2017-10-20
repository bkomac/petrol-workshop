package si.petrol.workshop.market.models.db;

import si.petrol.workshop.market.lib.Supplier;
import si.petrol.workshop.market.lib.common.BaseType;
import si.petrol.workshop.market.models.db.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "ProductEntitiy.findAll",
                query = "SELECT p FROM ProductEntity p ORDER BY p.createdAt DESC "),
        @NamedQuery(name = "ProductEntitiy.findAllCount",
                query = "SELECT count(p.id) FROM ProductEntity p ")
})
public class ProductEntity extends BaseEntity {

    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "currency")
    private String currency;

    //private List<String> tags;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

}
