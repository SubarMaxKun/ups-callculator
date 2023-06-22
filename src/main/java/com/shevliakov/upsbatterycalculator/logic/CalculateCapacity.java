/* (C)2023 */
package com.shevliakov.upsbatterycalculator.logic;

/** CalculateCapacity class is used to calculate capacity of battery in Ah */
public class CalculateCapacity {

    /**
     * Calculate method is used to calculate capacity of battery in Ah
     *
     * @param consumedPower consumed power in W
     * @param workingTime working time in hours
     * @param batteryVoltage battery voltage in V
     * @param inverterEfficiency inverter efficiency as float
     * @return capacity of battery in Ah
     */
    public int calculate(
            int consumedPower, int workingTime, int batteryVoltage, float inverterEfficiency) {
        return (int)
                Math.ceil((consumedPower * workingTime) / (batteryVoltage * inverterEfficiency));
    }
}
