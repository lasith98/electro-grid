package lk.sliit.customercareservice.model;

public class CustomerCareModel {
    private Long id;
    private Long customerId;
    private Long bilAccount;
    private String complainType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBilAccount() {
        return bilAccount;
    }

    public void setBilAccount(Long bilAccount) {
        this.bilAccount = bilAccount;
    }

    public String getComplainType() {
        return complainType;
    }

    public void setComplainType(String complainType) {
        this.complainType = complainType;
    }
}
