package case_study.models;

import java.util.Date;

public class Customer extends Person{
    private int customerId;
    private String customerType;
    private String adđress;

    public Customer() {
    }

    public Customer(String name, Date birthDay, String gender, String cmnd, Number phone, String email, int customerId, String customerType, String adđress) {
        super(name, birthDay, gender, cmnd, phone, email);
        this.customerId = customerId;
        this.customerType = customerType;
        this.adđress = adđress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

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
                "customerId=" + customerId +
                ", customerType='" + customerType + '\'' +
                ", adđress='" + adđress + '\'' +
                '}';
    }
}
