/**
 * Name: Pranjal Prasanna Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/20/2024
 * File Name: CustomerDataImplementation_USB.java
 * Description: This Class is an Implementation of USB data interface.
 */
package edu.bu.met.cs665.usb;
import java.util.ArrayList;
import java.util.List;
public class CustomerDataImplementation_USB implements CustomerData_USB {


    public List<CustomerProfile_USB> accessData() {

        return this.customerData_USB;
    }

    @Override
    public void printCustomer(int customerId) {
        System.out.print(this.customerData_USB.get(customerId).toString());
    }

    @Override
    public void getCustomer_USB(int customerId) {

        this.customerProfile_USB = customerData_USB.get(customerId);
    }

    private List<CustomerProfile_USB> customerData_USB;
    private CustomerProfile_USB customerProfile_USB;

    public CustomerDataImplementation_USB() {

        this.customerData_USB = new ArrayList<>();
    }

    public void addCustomer(CustomerProfile_USB customer) {

        this.customerData_USB.add(customer);
    }

    public void deleteCustomer(CustomerProfile_USB customer) {

        this.customerData_USB.remove(customer);
    }


    public CustomerProfile_USB getActiveCustomer_USB() {

        return this.customerProfile_USB;
    }

}
