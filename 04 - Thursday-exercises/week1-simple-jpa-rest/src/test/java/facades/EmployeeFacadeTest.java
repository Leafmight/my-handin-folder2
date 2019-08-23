/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class EmployeeFacadeTest {
    
    public EmployeeFacadeTest() {
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
     * Test of getEmployeeById method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeeById() {
        System.out.println("getEmployeeById");
        Integer id = 2;
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EmployeeFacade instance = EmployeeFacade.getFacadeExample(emf);
        Employee result = instance.getEmployeeById( id.longValue());
        Employee expResult= (Employee) new Employee("Hans", "Sejvej", 1000);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEmployeesByName method, of class EmployeeFacade.
     */
//    @Test
//    public void testGetEmployeesByName() {
//        System.out.println("getEmployeesByName");
//        String name = "Hans";
//        EmployeeFacade instance = new EmployeeFacade();
//        Employee expResult = null;
//        Employee result = instance.getEmployeesByName(name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of allEmployees method, of class EmployeeFacade.
     */
//    @Test
//    public void testAllEmployees() {
//        System.out.println("allEmployees");
//        EmployeeFacade instance = null;
//        List<Employee> expResult = null;
//        List<Employee> result = instance.allEmployees();
//        assertEquals(expResult, result);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getEmployeesWithHighestSalary method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeesWithHighestSalary() {
        System.out.println("getEmployeesWithHighestSalary");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EmployeeFacade instance = EmployeeFacade.getFacadeExample(emf);
        List<Employee> expResult = new ArrayList();
        expResult.add(new Employee("Hans", "Sejvej", 1000));
        List<Employee> result = instance.getEmployeesWithHighestSalary();
        assertEquals(expResult.get(0).getSalary(), result.get(0).getSalary(),0);
        
    }

    /**
     * Test of createEmployee method, of class EmployeeFacade.
     */
//    @Test
//    public void testCreateEmployee() {
//        System.out.println("createEmployee");
//        String name = "";
//        String address = "";
//        double salary = 0.0;
//        EmployeeFacade instance = null;
//        Employee expResult = null;
//        Employee result = instance.createEmployee(name, address, salary);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
