package com.johnson.mvptest.model;

import com.johnson.mvptest.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/8.
 */
public class UserModel implements IUserModel {
    private List<UserBean> userList=new ArrayList<UserBean>();
    private List<Integer> idList=new ArrayList<Integer>();
    private int id;
    private String firstName;
    private String lastName;
    @Override
    public void setId(int id) {
        id=id;
    }

    @Override
    public void setFirstName(String firstName) {
        firstName=firstName;
    }

    @Override
    public void setLastName(String lastName) {
        lastName=lastName;
    }

    public List<UserBean> getUserList() {
        return userList;
    }

    public void setUserList(List<UserBean> userList) {
        this.userList = userList;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public UserBean Load(int id) {
        if(idList.contains(new Integer(id))){
            UserBean user=userList.get(idList.indexOf(new Integer(id)));
            return user;
        }else{
            return null;
        }

    }
}
