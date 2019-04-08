package com.example.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.example.demo.okhttp.InterfaceName;
import com.example.demo.okhttp.Method;
import com.example.demo.okhttp.entity.entity.UserEntity;
import com.example.demo.okhttp.entity.response.UserResponse;
import com.example.demo.ui.WinToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Method method;

    @BindView(R.id.login)
    Button loginButton;

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        method = new Method();
    }

    @OnClick(R.id.login)
    public void onClick(View v) {
        System.out.println("Text:" + username.getText().toString() + ' ' + password.getText().toString());


        if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            WinToast.makeText(v.getContext(), "请输入用户名和密码！").show();
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(username.getText().toString());
            userEntity.setUserPassword(password.getText().toString());
            System.out.println("UserEntity:" + userEntity.getUserName() + " " + userEntity.getUserPassword());

            method.getLogin(userEntity).subscribe(loginResponse -> {
                if (loginResponse.id == 0) {
                    WinToast.makeText(v.getContext(), "账号或密码错误！").show();
                } else {
                    int id = loginResponse.id;
                    WinToast.makeText(v.getContext(), "登陆成功！").show();
                    System.out.println("id:" + id);
                }
            });
        }
    }

}