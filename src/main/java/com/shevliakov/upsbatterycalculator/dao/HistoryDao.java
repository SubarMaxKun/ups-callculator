package com.shevliakov.upsbatterycalculator.dao;

public interface HistoryDao {

  void addHistory(Object history);

  void deleteHistoryByUserId(int userId);

  Object getHistoryByUserId(int userId);

}
