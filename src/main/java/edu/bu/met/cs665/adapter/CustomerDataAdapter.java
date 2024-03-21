/**
 * Name: Pranjal Prasanna Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/20/2024
 * File Name: CustomerDataAdapter.java
 * Description: This class is the Bridge class for HTTPS and USB data.
 */
package edu.bu.met.cs665.adapter;
import edu.bu.met.cs665.https.CustomerDataImplementation_HTTPS;
import edu.bu.met.cs665.https.CustomerProfile_HTTPS;
import edu.bu.met.cs665.usb.CustomerDataImplementation_USB;
import edu.bu.met.cs665.usb.CustomerData_USB;
import edu.bu.met.cs665.usb.CustomerProfile_USB;
public class CustomerDataAdapter implements CustomerData_USB {
    private CustomerDataImplementation_USB customerData_USB;
    private CustomerDataImplementation_HTTPS customerData_HTTPS;
    private CustomerProfile_HTTPS customerProfile_HTTPS;
    public CustomerDataAdapter(CustomerDataImplementation_USB customerData_USB) {
        this.customerData_USB = customerData_USB;
    }
    /**
     * This internal method iterates through a list of USB data and converts
     * it to HTTPS before setting it to the adapter class.
     */
    private void convertToHTTPS() {
        CustomerDataImplementation_HTTPS convertedData = new CustomerDataImplementation_HTTPS();
        for (CustomerProfile_USB profile : this.customerData_USB.accessData()) {
            convertedData.addCustomer(new CustomerProfile_HTTPS(profile.getCustomerName(), profile.getCustomerId()));
        }
        this.customerData_HTTPS = convertedData;
    }
    /**
     * Converts USB data to HTTPS and sets the active customer using the provided customer ID.
     * @param customerId The ID of the customer we wish to set as active.
     */
    @Override
    public void getCustomer_USB(int customerId) {
        convertToHTTPS();
        this.customerData_HTTPS.getCustomer_HTTPS(customerId);
        this.customerProfile_HTTPS = this.customerData_HTTPS.getActiveCustomer_HTTPS();
    }
    /**
     * Due to how adapter class is setup, we require this method to access the active customer.
     * The active customer is set by using getCustomer_USB or printCustomer.
     * @return customerProfile_HTTPS is active customer set based on the last method called.
     */
    public CustomerProfile_HTTPS getActiveCustomer() {
        if (customerProfile_HTTPS != null) {
            return this.customerProfile_HTTPS;
        } else {
            throw new NullPointerException("Use getCustomer_USB or printCustomer, active customer is set after usage of either method");
        }
    }
    /**
     * CConverts USB data to HTTPS, sets the active customer, and prints the customer
     * profile based on the provided customer ID.
     * @param customerId The ID of the customer whose profile we wish to print.
     */
    @Override
    public void printCustomer(int customerId) {
        convertToHTTPS();
        this.customerData_HTTPS.getCustomer_HTTPS(customerId);
        this.customerProfile_HTTPS = this.customerData_HTTPS.getActiveCustomer_HTTPS();
        System.out.println(this.customerData_HTTPS.getActiveCustomer_HTTPS());
    }
}