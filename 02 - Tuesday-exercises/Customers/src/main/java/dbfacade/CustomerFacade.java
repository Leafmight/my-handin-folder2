/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class CustomerFacade {

    private static EntityManagerFactory emf;

    public Customer findByID(int id) {

        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }

    public Customer findByLastName(String name) {

        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, name);
            return customer;
        } finally {
            em.close();
        }
    }

    public int getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q1 = em.createQuery("SELECT COUNT(ID) FROM customers.CUSTOMER ID", Customer.class);
            return q1.getFirstResult();
        } finally {
            em.close();
        }

    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("SELECT Customer FROM customers.CUSTOMER", Customer.class);
            // List<Customer> customers = query.getResultList();
            // return customers; // disse 2 linjer er det samme som der allerede står bare delt op.
            return query.getResultList();
        } finally {
            em.close();

        }
    }

    public Customer addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

}
