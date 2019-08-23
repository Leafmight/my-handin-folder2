package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample {

    private static FacadeExample instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeExample() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CustomerDTO getCustomerByID(Long id){
        EntityManager em = emf.createEntityManager();
        try {
            BankCustomer customer = em.find(BankCustomer.class, id);
            CustomerDTO cDTO = new CustomerDTO(customer);
            return cDTO;
        } finally {
            em.close();
        }
    }

    public List<CustomerDTO> getCustomerByName(String name){
         EntityManager em = emf.createEntityManager();
       try {
            Query query
                    = em.createQuery("SELECT customer FROM BankCustomer customer WHERE customer.name = :name", BankCustomer.class);
            query.setParameter("name", name);
            List<BankCustomer> bcl = new ArrayList();
            List<CustomerDTO> cDTOl = new ArrayList();
            for (BankCustomer c : bcl) {
               cDTOl.add(new CustomerDTO(c));
           }
            
           return cDTOl;
        } finally {
            em.close();

        }
    }

    public BankCustomer addCustomer(BankCustomer cust){
        
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }
    public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<BankCustomer> query
                    = em.createQuery("SELECT bc FROM BankCustomer bc", BankCustomer.class);
            // List<Customer> customers = query.getResultList();
            // return customers; // disse 2 linjer er det samme som der allerede står bare delt op.
            return query.getResultList();
        } finally {
            em.close();

        }
    }
}
