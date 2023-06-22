/* (C)2023 */
package com.shevliakov.upsbatterycalculator.dao.impl;

import com.shevliakov.upsbatterycalculator.dao.BatteryDao;
import com.shevliakov.upsbatterycalculator.entity.Battery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class BatteryDaoImpl implements BatteryDao {

    private EntityManager entityManager;

    private void init() {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("com.shevliakov.upsbatterycalculator");
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @Override
    public void addBattery(Object battery) {
        init();
        entityManager.persist(battery);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateBattery(Object battery) {
        init();
        entityManager.merge(battery);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteBattery(Object battery) {
        init();
        entityManager.remove(battery);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Battery> getAllBatteries() {
        init();
        List<Battery> batteries =
                entityManager.createQuery("SELECT b FROM Battery b").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return batteries;
    }

    @Override
    public List<Battery> getBatteriesByCapacity(int capacity, int voltage) {
        init();
        List<Battery> batteries =
                entityManager
                        .createQuery(
                                "SELECT b FROM Battery b WHERE b.capacity >= :capacity and"
                                        + " b.voltage = :voltage")
                        .setParameter("capacity", capacity)
                        .setParameter("voltage", voltage)
                        .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return batteries;
    }

    @Override
    public Object getBatteryById(int id) {
        init();
        Object battery = entityManager.find(Object.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return battery;
    }

    @Override
    public Object getBatteryByModel(String model) {
        init();
        Object battery = entityManager.find(Object.class, model);
        entityManager.getTransaction().commit();
        entityManager.close();
        return battery;
    }
}
