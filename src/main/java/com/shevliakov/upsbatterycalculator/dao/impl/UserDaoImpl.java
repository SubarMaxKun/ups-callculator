/* (C)2023 */
package com.shevliakov.upsbatterycalculator.dao.impl;

import com.shevliakov.upsbatterycalculator.dao.UserDao;
import com.shevliakov.upsbatterycalculator.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/** UserDaoImpl class implements UserDao interface */
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    /** Initializes entity manager */
    private void init() {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("com.shevliakov.upsbatterycalculator");
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    /**
     * Adds user to database
     *
     * @param user user to add
     */
    @Override
    public void addUser(Object user) {
        init();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Updates user in database by username
     *
     * @param username user's username
     * @param password user's password
     */
    @Override
    public void updateUserPasswordByUsername(String username, String password) {
        init();
        entityManager
                .createQuery(
                        "UPDATE User u SET u.password = :password WHERE u.username = :username")
                .setParameter("password", password)
                .setParameter("username", username)
                .executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Deletes user from database
     *
     * @param user user to delete
     */
    @Override
    public void deleteUser(Object user) {
        init();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteUserByUsername(String username) {
        init();
        entityManager
                .createQuery("DELETE FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Gets user from database by id
     *
     * @param id user's id
     * @return user
     */
    @Override
    public Object getUserById(int id) {
        init();
        Object user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    /**
     * Gets user from database by username
     *
     * @param username user's username
     * @return user
     */
    @Override
    public Object getUserByUsername(String username) {
        init();
        Object user =
                entityManager
                        .createQuery("SELECT u FROM User u WHERE u.username = :username")
                        .setParameter("username", username)
                        .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    /**
     * Gets all users from database
     *
     * @return list of users
     */
    @Override
    public List<User> getAllUsers() {
        init();
        List<User> users = entityManager.createQuery("SELECT u FROM User u").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }
}
