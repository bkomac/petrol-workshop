package si.petrol.workshop.market.models.db;


import si.petrol.workshop.market.lib.enums.CustomerStatus;
import si.petrol.workshop.market.models.db.common.BaseEntity;

import javax.persistence.*;
import javax.xml.bind.ValidationEventLocator;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class CurtomerEntity extends BaseEntity
{

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private CustomerStatus status;
    @Column(name = "email")
    private String email;
    @Column(name = "date_birth")
    private LocalDate dateOfBirth;


    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }


}
