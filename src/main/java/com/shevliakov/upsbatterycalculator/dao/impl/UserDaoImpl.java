/* (C)2023 */
package com.shevliakov.upsbatterycalculator.dao.impl;

import com.shevliakov.upsbatterycalculator.dao.UserDao;
import com.shevliakov.upsbatterycalculator.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    private void init() {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("com.shevliakov.upsbatterycalculator");
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @Override
    public void addUser(Object user) {
        init();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

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

    @Override
    public void deleteUser(Object user) {
        init();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Object getUserById(int id) {
        init();
        Object user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

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

    @Override
    public List<User> getAllUsers() {
        init();
        List<User> users = entityManager.createQuery("SELECT u FROM User u").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }
}
