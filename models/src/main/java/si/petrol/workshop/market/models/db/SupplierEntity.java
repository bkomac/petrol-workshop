package si.petrol.workshop.market.models.db;

import si.petrol.workshop.market.lib.common.BaseType;
import si.petrol.workshop.market.lib.enums.SupplierStatus;
import si.petrol.workshop.market.models.db.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */

@Entity
@Table(name = "suppliers")
public class SupplierEntity extends BaseEntity {
    @Column(name = "company_name")
    private String companyName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private SupplierStatus status;

    @OneToMany(mappedBy = "supplier")
    private List<ProductEntity> products;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public SupplierStatus getStatus() {
        return status;
    }

    public void setStatus(SupplierStatus status) {
        this.status = status;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
