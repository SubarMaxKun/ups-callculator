/* (C)2023 */
package com.shevliakov.upsbatterycalculator.logic.controllers;

import com.shevliakov.upsbatterycalculator.dao.impl.HistoryDaoImpl;
import com.shevliakov.upsbatterycalculator.dao.impl.UserDaoImpl;
import com.shevliakov.upsbatterycalculator.entity.User;
import io.github.palexdev.materialfx.controls.MFXListView;
import javafx.collections.FXCollections;

/** Controller for HistoryStage */
public class HistoryController {

    public MFXListView HistoryListView;
    User user = new User();
    HistoryDaoImpl historyDaoImpl = new HistoryDaoImpl();

    /** Method to load user's search history */
    private void loadHistory() {
        try {
            HistoryListView.setItems(
                    FXCollections.observableArrayList(
                            historyDaoImpl.getHistoryByUserId(user.getId())));
        } catch (Exception e) {
            HistoryListView.setVisible(false);
        }
    }

    /**
     * Method to set authorized user
     *
     * @param username user's username
     */
    public void setUser(String username) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        user = (User) userDaoImpl.getUserByUsername(username);
        loadHistory();
    }
}
