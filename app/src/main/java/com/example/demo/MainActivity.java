package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.demo.activity.HomeActivity;
import com.example.demo.okhttp.Method;
import com.example.demo.okhttp.entity.entity.UserEntity;
import com.example.demo.util.StringUtil;
import com.example.demo.util.SystemUtil;
import com.example.demo.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {

    private Method method;

    @BindView(R.id.btn_login)
    Button loginButton;

    @BindView(R.id.et_user_account)
    EditText mEtAccount;

    @BindView(R.id.et_user_password)
    EditText mEtPassword;

    @BindView(R.id.iv_delete_account)
    ImageView mIvDeleteAccount;

    @BindView(R.id.iv_delete_password)
    ImageView mIvDeletePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ToastUtil.init(this);
        method = new Method();
    }

    @OnTextChanged(R.id.et_user_account)
    public void onAccountTextChange(CharSequence s) {
        int visible = StringUtil.isEmpty(s.toString()) ? View.GONE : View.VISIBLE;
        mIvDeleteAccount.setVisibility(visible);
    }

    @OnTextChanged(R.id.et_user_password)
    public void onPasswordTextChange(CharSequence s) {
        int visible = StringUtil.isEmpty(s.toString()) ? View.GONE : View.VISIBLE;
        mIvDeletePassword.setVisibility(visible);
    }

    @OnClick({R.id.iv_delete_account, R.id.iv_delete_password, R.id.btn_login, R.id.tv_forget_password, R.id.tv_go_to_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_delete_account:
                mEtAccount.setText("");
                break;
            case R.id.iv_delete_password:
                mEtPassword.setText("");
                break;
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_forget_password:
                ToastUtil.showToast("该功能还未开发");
                break;
            case R.id.tv_go_to_register:
                ToastUtil.showToast("该功能还未开发");
                break;
        }
    }

    private void login() {
        System.out.println("Text:" + mEtAccount.getText().toString() + ' ' + mEtPassword.getText().toString());


        // 隐藏软键盘
        SystemUtil.hideKeyBoard(this);

        // 验证用户名是否为空
        final String typea_account = mEtAccount.getText().toString().trim();
        if (TextUtils.isEmpty(typea_account)) {
            ToastUtil.showToast(R.string.toast_error_empty_account);
            return;
        }
        // 验证密码是否为空
        final String type_password = mEtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(type_password)) {
            ToastUtil.showToast(R.string.toast_error_empty_password);
            return;
        }
        // 禁用登录按钮,避免重复点击
        loginButton.setEnabled(false);

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(mEtAccount.getText().toString());
        userEntity.setUserPassword(mEtPassword.getText().toString());
        System.out.println("UserEntity:" + userEntity.getUserName() + " " + userEntity.getUserPassword());

        method.getLogin(userEntity).subscribe(loginResponse -> {
            if (loginResponse.id == 0) {
                ToastUtil.showToast(R.string.toast_error_fail_login);
            } else {
                int id = loginResponse.id;
                ToastUtil.showToast(R.string.toast_success_login);
                System.out.println("id:" + id);
                startActivity(new Intent(this,HomeActivity.class));
            }
        });
    }

}