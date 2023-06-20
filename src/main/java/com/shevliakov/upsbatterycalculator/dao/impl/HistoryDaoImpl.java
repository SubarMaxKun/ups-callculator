package com.shevliakov.upsbatterycalculator.dao.impl;

import com.shevliakov.upsbatterycalculator.dao.HistoryDao;
import com.shevliakov.upsbatterycalculator.entity.History;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class HistoryDaoImpl implements HistoryDao {

  private EntityManager entityManager;

  private void init() {
    EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory(
        "com.shevliakov.upsbatterycalculator");
    entityManager = sessionFactory.createEntityManager();
    entityManager.getTransaction().begin();
  }

  @Override
  public void addHistory(Object history) {
    init();
    entityManager.persist(history);
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  @Override
  public void deleteHistoryByUserId(int userId) {
    init();
    entityManager.createQuery(
            "DELETE FROM History h WHERE h.userId = :userId")
        .setParameter("userId", userId)
        .executeUpdate();
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  @Override
  public List<History> getHistoryByUserId(int userId) {
    init();
    List<History> history = entityManager.createQuery(
            "SELECT h FROM History h WHERE h.userId = :userId")
        .setParameter("userId", userId)
        .getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    return history;
  }
}
