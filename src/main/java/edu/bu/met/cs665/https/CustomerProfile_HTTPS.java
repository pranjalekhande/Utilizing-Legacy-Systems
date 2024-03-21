/**
 * Name: Pranjal Prasanna Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/20/2024
 * File Name: CustomerProfile_HTTPS.java
 * Description: This Class is HTTPS-based customer profile.
 */
package edu.bu.met.cs665.https;

import java.util.Objects;
public class CustomerProfile_HTTPS {
    private String customerName;
    private int customerId;

    public CustomerProfile_HTTPS(String customerName, int customerId) {
        super();
        this.customerName = customerName;
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
        CustomerProfile_HTTPS other = (CustomerProfile_HTTPS) obj;
        return customerId == other.customerId && Objects.equals(customerName, other.customerName);
    }

    @Override
    public String toString() {
        return "CustomerProfile_HTTPS [customerName=" + customerName + ", customerId=" + customerId + "]";
    }

}
