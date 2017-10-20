package si.petrol.workshop.market.models.db;

import si.petrol.workshop.market.lib.CartItem;
import si.petrol.workshop.market.lib.common.BaseType;
import si.petrol.workshop.market.models.db.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Set;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
@Entity
@Table(name = "carts")
public class CartEntity extends BaseEntity {

    @Column(name = "expires_at")
    private Instant expiresAt;

    @OneToMany(mappedBy = "cart")
    private Set<CartItemEntity> items;

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Set<CartItemEntity> getItems() {
        return items;
    }

    public void setItems(Set<CartItemEntity> items) {
        this.items = items;
    }
}
