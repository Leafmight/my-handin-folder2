package facades;

import entities.Employee;
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
public class EmployeeFacade {

    public static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    EmployeeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }
    

    public Employee getEmployeeById(Long id) {

        EntityManager em = emf.createEntityManager();
        try {
            Employee customer = em.find(Employee.class, id);
            return customer;
        } finally {
            em.close();
        }
    }

    public Employee getEmployeesByName(String name) {

        EntityManager em = emf.createEntityManager();
       try {
            Query query
                    = em.createQuery("SELECT employee FROM Employee employee WHERE employee.name = :name", Employee.class);
            query.setParameter("name", name);
            return (Employee) query.getSingleResult();
        } finally {
            em.close();

        }
    }

    public List<Employee> allEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query
                    = em.createQuery("SELECT employee FROM Employee employee", Employee.class);
            // List<Customer> customers = query.getResultList();
            // return customers; // disse 2 linjer er det samme som der allerede står bare delt op.
            return query.getResultList();
        } finally {
            em.close();

        }
    }

    public List<Employee> getEmployeesWithHighestSalary() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query
                    = em.createQuery("SELECT e FROM Employee e where e.salary = (SELECT MAX(employee.salary) FROM Employee employee)", Employee.class);
 
            return query.getResultList();
        } finally {
            em.close();

        }
    }
    public Employee createEmployee(String name, String address, double salary) {
        Employee employee = new Employee(name, address, salary);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } finally {
            em.close();
        }
    }
}
