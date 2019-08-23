/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacade;

import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class CustomerFacadeTest {
    
    public CustomerFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findByID method, of class CustomerFacade.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        int id = 1;
        CustomerFacade instance = new CustomerFacade();
        Customer expResult = new Customer("Hans","Hansen");
        Customer result = instance.findByID(id);
        assertEquals(expResult, result);
 
    }

    /**
     * Test of findByLastName method, of class CustomerFacade.
     */
    @Test
    public void testFindByLastName() {
        System.out.println("findByLastName");
        String name = "Hansen";
        CustomerFacade instance = new CustomerFacade();
        Customer expResult = new Customer("Hans", "Hansen");
        Customer result = instance.findByLastName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfCustomers method, of class CustomerFacade.
     */
    @Test
    public void testGetNumberOfCustomers() {
        System.out.println("getNumberOfCustomers");
        CustomerFacade instance = new CustomerFacade();
        int expResult = 2;
        int result = instance.getNumberOfCustomers();
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of allCustomers method, of class CustomerFacade.
//     */
//    @Test
//    public void testAllCustomers() {
//        System.out.println("allCustomers");
//        CustomerFacade instance = new CustomerFacade();
//        List<Customer> expResult = new ArrayList();
//        expResult.add(Customer("Hans", "Hansen"));
//        expResult.add(Customer("Jens", "Jensen"));
//        List<Customer> result = instance.allCustomers();
    
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addCustomer method, of class CustomerFacade.
//     */
//    @Test
//    public void testAddCustomer() {
//        System.out.println("addCustomer");
//        String firstName = "";
//        String lastName = "";
//        CustomerFacade instance = new CustomerFacade();
//        Customer expResult = null;
//        Customer result = instance.addCustomer(firstName, lastName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
