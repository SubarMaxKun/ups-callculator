/* (C)2023 */
package com.shevliakov.upsbatterycalculator.logic.authorization;

import com.shevliakov.upsbatterycalculator.dao.impl.UserDaoImpl;
import com.shevliakov.upsbatterycalculator.entity.User;
import com.shevliakov.upsbatterycalculator.logic.Hash;
import java.util.List;

public class SignIn {

    private String username;
    private String password;

    public boolean signIn(String username, String password) {
        this.username = username;
        this.password = password;

        return checkUserData();
    }

    private boolean checkUserData() {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        List<User> users = userDaoImpl.getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(Hash.getHash(password))) {
                return true;
            }
        }
        return false;
    }
}
