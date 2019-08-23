/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import facades.FacadeExample;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class MakeTestData {
      public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        BankCustomer bc1 = new BankCustomer("Hans", "Hansen", "8888888888888888");
        BankCustomer bc2 = new BankCustomer("Jens", "Jensen", "9999999999999999");

        try {
            em.getTransaction().begin();
            em.persist(bc1);
            em.persist(bc2);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
}
