package com.johnson.mvptest.model;

import com.johnson.mvptest.bean.UserBean;

/**
 * Created by Administrator on 2016/6/8.
 */
public interface IUserModel {
    void setId(int id);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    int getId();

    UserBean Load(int id);
}
