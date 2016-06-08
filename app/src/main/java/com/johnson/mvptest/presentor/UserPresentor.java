package com.johnson.mvptest.presentor;

import android.widget.Toast;

import com.johnson.mvptest.MyApplication;
import com.johnson.mvptest.bean.UserBean;
import com.johnson.mvptest.model.IUserModel;
import com.johnson.mvptest.model.UserModel;
import com.johnson.mvptest.view.IUserView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/8.
 */
public class UserPresentor {
    private List<UserBean> userList;
    private List<Integer> idList;
    IUserView mUserView;
    UserModel mUserModel;

    public UserModel getmUserModel() {
        return mUserModel;
    }

    public List<UserBean> getUserList() {
        return userList;
    }

    public void setUserList(List<UserBean> userList) {
        this.userList = userList;
    }

    public UserPresentor(IUserView view) {
        mUserModel = new UserModel();
        mUserView = view;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void saveUser(int id, String firstName, String lastName) {
        UserBean user = new UserBean(id, firstName, lastName);
        userList = mUserModel.getUserList();
        idList = mUserModel.getIdList();
        userList.add(user);
        idList.add(id);
    }

    public void loadUser(int id) {
        UserBean user = mUserModel.Load(id);
        if (user != null) {
            mUserView.setFirstName(user.getFirstName());
            mUserView.setLastName(user.getLastName());
        }else{
            Toast.makeText(MyApplication.getContext(),"can't find your id",Toast.LENGTH_SHORT).show();
        }
    }

}
