/**
 * Name: Pranjal Prasanna Ekhande
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/20/2024
 * File Name: Main.java
 * Description: This class used for running the application
 */

package edu.bu.met.cs665;
import edu.bu.met.cs665.adapter.CustomerDataAdapter;
import edu.bu.met.cs665.usb.CustomerDataImplementation_USB;
import edu.bu.met.cs665.usb.CustomerProfile_USB;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * A main method to run examples.
   * You may use this method for development purposes as you start building your
   * assignments/final project.  This could prove convenient to test as you are developing.
   * However, please note that every assignment/final projects requires JUnit tests.
   */
  public static void main(String[] args) {
    CustomerDataImplementation_USB customerData_USB;
    CustomerDataAdapter customerDataAdapter;

    // Note how each customer profile is of type USB. (to Convert)
    customerData_USB = new CustomerDataImplementation_USB();
    customerData_USB.addCustomer(new CustomerProfile_USB("Bella", 0));
    customerData_USB.addCustomer(new CustomerProfile_USB("Mike", 1));
    customerData_USB.addCustomer(new CustomerProfile_USB("Kate", 2));
    customerData_USB.addCustomer(new CustomerProfile_USB("Chris", 3));
    customerData_USB.addCustomer(new CustomerProfile_USB("Reeve", 4));

    // Conversion of USB to HTTPS. Input -> USB data and Returns -> HTTPS.
    customerDataAdapter = new CustomerDataAdapter(customerData_USB);

    // Note: how output customer profiles are of type HTTPS.(from conversion)
    customerDataAdapter.printCustomer(0);
    customerDataAdapter.printCustomer(1);
    customerDataAdapter.printCustomer(2);
    customerDataAdapter.printCustomer(3);
    customerDataAdapter.printCustomer(4);
  }


}
