package com.johnson.mvptest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.johnson.mvptest.R;
import com.johnson.mvptest.presentor.UserPresentor;

public class ViewActivity extends AppCompatActivity implements IUserView {
    private Button save, read;
    private UserPresentor mPresentor;
    private EditText id, first, last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.edit1);
        first = (EditText) findViewById(R.id.edit2);
        last = (EditText) findViewById(R.id.edit3);
        save = (Button) findViewById(R.id.btn_save);
        read = (Button) findViewById(R.id.btn_read);
//        save.setOnClickListener(this);
//        read.setOnClickListener(this);
        mPresentor = new UserPresentor(this);
        setOnClick();
    }

    private void setOnClick() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresentor.saveUser(getId(), getFirstName(), getLastName());
                id.setText("");
                first.setText("");
                last.setText("");
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("".equals(id.getText().toString())) {
                    Toast.makeText(ViewActivity.this, "please type in id", Toast.LENGTH_SHORT).show();
                } else if (!mPresentor.getmUserModel().getIdList().contains(new Integer(id.getText().toString()))) {
                    Toast.makeText(ViewActivity.this, "can't find this id", Toast.LENGTH_SHORT).show();
                } else {
                    mPresentor.loadUser(getId());
                }
            }
        });
    }

//    @Override
//    public void onClick(View view) {
//        if ("".equals(id.getText()) && mPresentor.getUserList().isEmpty()) {
//            switch (view.getId()) {
//                case R.id.btn_read:
//                    Toast.makeText(this, "please type in id", Toast.LENGTH_SHORT).show();
//            }
//        }
//        switch (view.getId()) {
//            case R.id.btn_save:
//                mPresentor.saveUser(getId(), getFirstName(), getLastName());
//                id.setText("");
//                first.setText("");
//                last.setText("");
//                break;
//            case R.id.btn_read:
//                mPresentor.loadUser(getId());
//                break;
//            default:
//                break;
//        }
//    }

    @Override
    public int getId() {
        return new Integer(id.getText().toString());
    }

    @Override
    public String getFirstName() {
        return first.getText().toString();
    }

    @Override
    public String getLastName() {
        return last.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        first.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        last.setText(lastName);
    }
}
