package com.shevliakov.upsbatterycalculator.logic.authorization;

public class CheckPasswordAvailability {
  public boolean checkPasswordAvailability(String password) {
    return password.length() >= 8 && password.length() <= 24 && !password.contains(" ")
        && !password.contains("\t") && !password.contains("\n") && !password.contains("\r");
  }
}
