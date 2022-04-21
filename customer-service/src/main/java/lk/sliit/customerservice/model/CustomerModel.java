package lk.sliit.customerservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerModel {

    private long customerId;
    private String firstName;
    private String lastName;
    private String nic;
    private String mobileNo;
    private String email;
    private String address;

}
