package com.shevliakov.upsbatterycalculator.dao;

import com.shevliakov.upsbatterycalculator.entity.Battery;
import java.util.List;

public interface BatteryDao {

  void addBattery(Object battery);

  void updateBattery(Object battery);

  void deleteBattery(Object battery);

  List<Battery> getAllBatteries();

  Object getBatteryById(int id);

  Object getBatteryByModel(String model);
}