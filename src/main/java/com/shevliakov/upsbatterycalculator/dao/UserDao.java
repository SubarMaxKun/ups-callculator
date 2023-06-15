package com.shevliakov.upsbatterycalculator.dao;

import com.shevliakov.upsbatterycalculator.entity.User;
import java.util.List;

public interface UserDao {

  void addUser(Object user);

  void updateUserPasswordByUsername(String username, String password);

  void deleteUser(Object user);

  Object getUserById(int id);

  Object getUserByUsername(String username);

  List<User> getAllUsers();
}
