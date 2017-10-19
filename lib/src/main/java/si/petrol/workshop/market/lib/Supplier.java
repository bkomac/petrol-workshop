package si.petrol.workshop.market.lib;

import si.petrol.workshop.market.lib.common.BaseType;
import si.petrol.workshop.market.lib.enums.SupplierStatus;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class Supplier extends BaseType {

    private String companyName;
    private SupplierStatus status;

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
}
