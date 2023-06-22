/* (C)2023 */
package com.shevliakov.upsbatterycalculator.dao;

import com.shevliakov.upsbatterycalculator.entity.User;
import java.util.List;

/** UserDao interface provides methods to work with users in database */
public interface UserDao {

    void addUser(Object user);

    void updateUserPasswordByUsername(String username, String password);

    void deleteUser(Object user);

    Object getUserById(int id);

    Object getUserByUsername(String username);

    List<User> getAllUsers();
}
