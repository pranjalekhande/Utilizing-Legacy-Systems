/**
 * Name: Pranjal Prasanna Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/20/2024
 * File Name: CustomerProfile_USB.java
 * Description: This Class is USB-based customer profile.
 */
package edu.bu.met.cs665.usb;
import java.util.Objects;
public class CustomerProfile_USB {
    private String customerName;
    private int customerId;
    public CustomerProfile_USB(String customerName, int customerId) {
        super();
        this.customerName = customerName;
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomerProfile_USB other = (CustomerProfile_USB) obj;
        return customerId == other.customerId && Objects.equals(customerName, other.customerName);
    }
    @Override
    public String toString() {
        return "CustomerProfile_USB [customerName=" + customerName + ", customerId=" + customerId + "]";
    }
}
