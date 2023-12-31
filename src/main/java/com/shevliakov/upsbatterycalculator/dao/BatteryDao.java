/* (C)2023 */
package com.shevliakov.upsbatterycalculator.dao;

import com.shevliakov.upsbatterycalculator.entity.Battery;
import java.util.List;

/** BatteryDao interface provides methods to work with batteries in database */
public interface BatteryDao {

    void addBattery(Object battery);

    void updateBattery(Object battery);

    void deleteBattery(Object battery);

    List<Battery> getAllBatteries();

    List<Battery> getBatteriesByCapacity(int capacity, int voltage);

    Object getBatteryById(int id);

    Object getBatteryByModel(String model);
}
