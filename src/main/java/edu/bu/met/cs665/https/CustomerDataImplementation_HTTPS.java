/**
 * Name: Pranjal Prasanna Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/20/2024
 * File Name: CustomerDataImplementation_HTTPS.java
 * Description: This Class is an Implementation of HTTPS data interface.
 */
package edu.bu.met.cs665.https;
import java.util.ArrayList;
import java.util.List;
public class CustomerDataImplementation_HTTPS implements CustomerData_HTTPS{
    private List<CustomerProfile_HTTPS> customerData_HTTPS;
    private CustomerProfile_HTTPS customerProfile_HTTPS;

    public CustomerDataImplementation_HTTPS() {
        this.customerData_HTTPS = new ArrayList<>();
    }

    public void addCustomer(CustomerProfile_HTTPS customer) {
        customerData_HTTPS.add(customer);
    }

    public void deleteCustomer(CustomerProfile_HTTPS customer) {
        customerData_HTTPS.remove(customer);
    }

    @Override
    public void printCustomer(int customerId) {
        System.out.print(customerData_HTTPS.get(customerId).toString());
    }

    @Override
    public void getCustomer_HTTPS(int customerId) {
        this.customerProfile_HTTPS = customerData_HTTPS.get(customerId);
    }

    public CustomerProfile_HTTPS getActiveCustomer_HTTPS() {
        return this.customerProfile_HTTPS;
    }
}
