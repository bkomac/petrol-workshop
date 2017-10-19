package si.petrol.workshop.market.lib;

import si.petrol.workshop.market.lib.common.BaseType;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class Product extends BaseType {

    private String title;
    private BigDecimal price;
    private String currency;
    private List<String> tags;
    private Supplier supplier;

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
