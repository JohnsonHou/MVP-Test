package com.johnson.mvptest.view;

/**
 * Created by Administrator on 2016/6/8.
 */
public interface IUserView {
    int getId();
    String getFirstName();
    String getLastName();
    void setFirstName(String firstName);
    void setLastName(String lastName);
}
