/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import facades.EmployeeFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class EntityTester {
      public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        EmployeeFacade instance = EmployeeFacade.getFacadeExample(emf);
//        Employee employee1 = new Employee("Hans", "Sejvej",1000);
//        Employee employee2 = new Employee("Jens", "Nejvej",10);
        try {
//            em.getTransaction().begin();
//            em.persist(employee1);
//            em.persist(employee2);
//            em.getTransaction().commit();
            //Verify that books are managed and has been given a database id
//            System.out.println(employee1.getId());
//            System.out.println(employee2.getId());
//            System.out.println(instance.getEmployeesWithHighestSalary());
            System.out.println(instance.getEmployeesByName("Hans"));

        } finally {
            em.close();
        }
    }  
}
