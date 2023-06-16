package com.shevliakov.upsbatterycalculator.logic.authorization;

import com.shevliakov.upsbatterycalculator.dao.impl.UserDaoImpl;
import com.shevliakov.upsbatterycalculator.entity.User;
import com.shevliakov.upsbatterycalculator.logic.Hash;
import java.util.List;

public class SignUp {

  private String username;
  private String password;

  public boolean signUp(String username, String password) {
    this.username = username;
    this.password = password;

    if (checkUsernameAvailability() && checkPasswordAvailability()) {
      UserDaoImpl userDaoImpl = new UserDaoImpl();
      userDaoImpl.addUser(new User(username, Hash.getHash(password)));
      return true;
    }
    return false;
  }

  private boolean checkUsernameAvailability() {
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    List<User> users = userDaoImpl.getAllUsers();

    for (User user : users) {
      if (user.getUsername().equals(username)) {
        return false;
      }
    }
    return true;
  }

  private boolean checkPasswordAvailability() {
    return password.length() >= 8 && password.length() <= 24 && !password.contains(" ")
        && !password.contains("\t") && !password.contains("\n") && !password.contains("\r");
  }
}