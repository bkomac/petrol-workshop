package si.petrol.workshop.market.lib;

import si.petrol.workshop.market.lib.common.BaseType;
import si.petrol.workshop.market.lib.enums.CustomerStatus;

import java.time.LocalDate;

/**
 * @author Tilen Faganel
 * @since 1.0.0
 */
public class Customer extends BaseType {

    private String firstName;
    private String lastName;
    private CustomerStatus status;
    private String email;
    private LocalDate dateOfBirth;
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
