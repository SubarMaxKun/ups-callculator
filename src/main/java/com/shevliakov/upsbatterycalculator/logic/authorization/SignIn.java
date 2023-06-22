/* (C)2023 */
package com.shevliakov.upsbatterycalculator.logic.authorization;

import com.shevliakov.upsbatterycalculator.dao.impl.UserDaoImpl;
import com.shevliakov.upsbatterycalculator.entity.User;
import com.shevliakov.upsbatterycalculator.logic.Hash;
import java.util.List;

/** SignIn class provides methods to sign in user */
public class SignIn {

    private String username;
    private String password;

    /**
     * Sign in
     *
     * @param username to be checked
     * @param password to be checked
     * @return boolean return true if user is signed in
     */
    public boolean signIn(String username, String password) {
        this.username = username;
        this.password = password;
        return checkUserData();
    }

    /**
     * Check user's data
     *
     * @return boolean return true if user's data is correct
     */
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
