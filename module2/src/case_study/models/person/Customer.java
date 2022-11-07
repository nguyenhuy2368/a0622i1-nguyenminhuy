package case_study.models.person;

import case_study.models.person.Person;

import java.util.Date;

public class Customer extends Person {
    private String customerId;
    private String customerType;
    private String adđress;

    public Customer() {
    }

    public Customer(String name, String birthDay, String gender, String cmnd, String phone, String email, String customerId, String customerType, String adđress) {
        super(name, birthDay, gender, cmnd, phone, email);
        this.customerId = customerId;
        this.customerType = customerType;
        this.adđress = adđress;
    }

    public String getCustomerId() { return customerId; }

    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAdđress() {
        return adđress;
    }

    public void setAdđress(String adđress) {
        this.adđress = adđress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerType='" + customerType + '\'' +
                ", adđress='" + adđress + '\'' +
                '}';
    }
}
