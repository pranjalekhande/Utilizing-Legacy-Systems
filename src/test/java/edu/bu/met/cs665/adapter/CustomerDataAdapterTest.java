package edu.bu.met.cs665.adapter;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.bu.met.cs665.https.CustomerProfile_HTTPS;
import edu.bu.met.cs665.usb.CustomerDataImplementation_USB;
import edu.bu.met.cs665.usb.CustomerProfile_USB;

public class CustomerDataAdapterTest {

    private CustomerDataImplementation_USB customerData_USB;
    private CustomerDataAdapter customerDataAdapter;

    @Before
    public void setUp() throws Exception {
        customerData_USB = new CustomerDataImplementation_USB();
        customerData_USB.addCustomer(new CustomerProfile_USB("Rick", 0));
        customerData_USB.addCustomer(new CustomerProfile_USB("Chris", 1));
        customerData_USB.addCustomer(new CustomerProfile_USB("Bella", 2));
        customerData_USB.addCustomer(new CustomerProfile_USB("Shelia", 3));
        customerData_USB.addCustomer(new CustomerProfile_USB("Mike", 4));
        customerDataAdapter = new CustomerDataAdapter(customerData_USB);
    }
    @Test
    public void testGetCustomer_USB_Success() {
        customerDataAdapter.getCustomer_USB(4);
        assertEquals(customerDataAdapter.getActiveCustomer(), new CustomerProfile_HTTPS("Mike", 4));
    }


    @Test
    public void testGetActiveCustomer_Success() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            customerDataAdapter.getActiveCustomer();
        });
        assertEquals("Use getCustomer_USB or printCustomer, active customer is set after usage of either method", ex.getMessage());
    }

    @Test
    public void testPrintCustomer_Success() {
        customerDataAdapter.printCustomer(0);
        // When printCustomer is called, the customer with the provided ID is set as active.
        // This avoids the need to directly check the output stream.
        assertEquals(customerDataAdapter.getActiveCustomer(), new CustomerProfile_HTTPS("Rick", 0));
    }



    @Test
    public void testPrintCustomer_Fail() {
        customerDataAdapter.printCustomer(0);
        // When printCustomer is called, the customer with the provided ID is set as active.
        // This avoids the need to directly check the output stream.
        assertNotEquals(customerDataAdapter.getActiveCustomer(), new CustomerProfile_HTTPS("Steven", 0));
    }

    @Test
    public void testGetCustomer_USB_Fail() {
        customerDataAdapter.getCustomer_USB(3);
        assertNotEquals(customerDataAdapter.getActiveCustomer(), new CustomerProfile_HTTPS("Michelle", 4));
    }

    @Test
    public void testGetActiveCustomer_Fail() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            customerDataAdapter.getActiveCustomer();
        });
        assertNotEquals("Michelle", ex.getMessage());
    }


}
