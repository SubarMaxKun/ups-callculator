/* (C)2023 */
package com.shevliakov.upsbatterycalculator.logic.authorization;

/** CheckPasswordAvailability class provides method to check password availability */
public class CheckPasswordAvailability {

    /**
     * Check password availability
     *
     * @param password to be checked
     * @return boolean return true if password is available
     */
    public boolean checkPasswordAvailability(String password) {
        return password.length() >= 8
                && password.length() <= 24
                && !password.contains(" ")
                && !password.contains("\t")
                && !password.contains("\n")
                && !password.contains("\r");
    }
}
