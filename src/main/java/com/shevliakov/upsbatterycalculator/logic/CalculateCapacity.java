package com.shevliakov.upsbatterycalculator.logic;

public class CalculateCapacity {
  public int calculate(int consumedPower, int workingTime, int batteryVoltage, float inverterEfficiency){
    return (int) Math.ceil((consumedPower * workingTime) / (batteryVoltage * inverterEfficiency));
  }
}
