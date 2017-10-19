package si.petrol.workshop.market.lib;

import si.petrol.workshop.market.lib.common.BaseType;

import java.time.Instant;
import java.util.Set;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class Cart extends BaseType {

    private Instant expiresAt;
    private Set<CartItem> items;

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }
}
