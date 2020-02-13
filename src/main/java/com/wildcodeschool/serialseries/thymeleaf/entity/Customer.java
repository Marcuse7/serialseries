/**
 * Created by AEr on 12.02.20.
 *//*



package com.wildcodeschool.serialseries.thymeleaf.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    private String firstName;

    private String lastName;

    private String address;

    public Customer() {
        super.setRole("CUSTOMER");
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Review> rewievs;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Order> orders;

    private void setRole(String role) {
        // do not change, always CUSTOMER! ! !
    }

}
*/
