/* (C)2023 */
package com.shevliakov.upsbatterycalculator.dao.impl;

import com.shevliakov.upsbatterycalculator.dao.HistoryDao;
import com.shevliakov.upsbatterycalculator.entity.History;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/** HistoryDaoImpl class implements HistoryDao interface */
public class HistoryDaoImpl implements HistoryDao {

    private EntityManager entityManager;

    /** Initializes entity manager */
    private void init() {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("com.shevliakov.upsbatterycalculator");
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    /**
     * Adds history to database
     *
     * @param history history to add
     */
    @Override
    public void addHistory(Object history) {
        init();
        entityManager.persist(history);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Deletes history from database
     *
     * @param userId user id, whose history must be deleted
     */
    @Override
    public void deleteHistoryByUserId(int userId) {
        init();
        entityManager
                .createQuery("DELETE FROM History h WHERE h.userId = :userId")
                .setParameter("userId", userId)
                .executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Gets history from database
     *
     * @param userId user id, whose history must be returned
     * @return list of history
     */
    @Override
    public List<History> getHistoryByUserId(int userId) {
        init();
        List<History> history =
                entityManager
                        .createQuery("SELECT h FROM History h WHERE h.userId = :userId")
                        .setParameter("userId", userId)
                        .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return history;
    }
}
