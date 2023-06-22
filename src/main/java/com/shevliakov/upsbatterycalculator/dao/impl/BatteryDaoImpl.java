/* (C)2023 */
package com.shevliakov.upsbatterycalculator.dao.impl;

import com.shevliakov.upsbatterycalculator.dao.BatteryDao;
import com.shevliakov.upsbatterycalculator.entity.Battery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/** BatteryDaoImpl class implements BatteryDao interface */
public class BatteryDaoImpl implements BatteryDao {

    private EntityManager entityManager;

    /**
     * Initializes entity manager
     */
    private void init() {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("com.shevliakov.upsbatterycalculator");
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    /**
     * Adds battery to database
     *
     * @param battery battery to add
     */
    @Override
    public void addBattery(Object battery) {
        init();
        entityManager.persist(battery);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Updates battery in database
     *
     * @param battery battery to update
     */
    @Override
    public void updateBattery(Object battery) {
        init();
        entityManager.merge(battery);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Deletes battery from database
     *
     * @param battery battery to delete
     */
    @Override
    public void deleteBattery(Object battery) {
        init();
        entityManager.remove(battery);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Gets all batteries from database
     *
     * @return List<Battery> returned list of batteries
     */
    @Override
    public List<Battery> getAllBatteries() {
        init();
        List<Battery> batteries =
                entityManager.createQuery("SELECT b FROM Battery b").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return batteries;
    }

    /**
     * Gets batteries from database by capacity
     *
     * @param capacity battery's capacity
     * @return List<Battery>
     */
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

    /**
     * Gets batteries from database by id
     *
     * @param id battery's id
     * @return List<Battery>
     */
    @Override
    public Object getBatteryById(int id) {
        init();
        Object battery = entityManager.find(Object.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return battery;
    }

    /**
     * Gets batteries from database by model
     *
     * @param model battery's model
     * @return List<Battery>
     */
    @Override
    public Object getBatteryByModel(String model) {
        init();
        Object battery = entityManager.find(Object.class, model);
        entityManager.getTransaction().commit();
        entityManager.close();
        return battery;
    }
}
