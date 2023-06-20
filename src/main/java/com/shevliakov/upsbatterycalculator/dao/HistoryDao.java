package com.shevliakov.upsbatterycalculator.dao;

import com.shevliakov.upsbatterycalculator.entity.History;
import java.util.List;

public interface HistoryDao {

  void addHistory(Object history);

  void deleteHistoryByUserId(int userId);

  List<History> getHistoryByUserId(int userId);

}
