package com.shevliakov.upsbatterycalculator;

import com.shevliakov.upsbatterycalculator.dao.impl.HistoryDaoImpl;
import com.shevliakov.upsbatterycalculator.dao.impl.UserDaoImpl;
import com.shevliakov.upsbatterycalculator.entity.User;
import io.github.palexdev.materialfx.controls.MFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HistoryController {

  public MFXListView HistoryListView;
  User user = new User();
  HistoryDaoImpl historyDaoImpl = new HistoryDaoImpl();

  private void loadHistory() {
    try {
      HistoryListView.setItems(FXCollections.observableArrayList(historyDaoImpl.getHistoryByUserId(
          user.getId())));
    } catch (Exception e) {
      System.out.println(e);
      HistoryListView.setVisible(false);
    }
  }

  public void setUser(String username) {
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    user = (User) userDaoImpl.getUserByUsername(username);
    loadHistory();
  }
}
