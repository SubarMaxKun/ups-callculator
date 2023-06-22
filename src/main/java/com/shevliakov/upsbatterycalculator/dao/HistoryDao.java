/* (C)2023 */
package com.shevliakov.upsbatterycalculator.dao;

import com.shevliakov.upsbatterycalculator.entity.History;
import java.util.List;

/** HistoryDao interface provides methods to work with history in database */
public interface HistoryDao {

    void addHistory(Object history);

    void deleteHistoryByUserId(int userId);

    List<History> getHistoryByUserId(int userId);
}
