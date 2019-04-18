package com.example.demo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.demo.R;
import com.example.demo.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopDetailActivity extends AppCompatActivity {

    private String shopname;

    private int shopid;

    @BindView(R.id.toolbar_shopdetail)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        ButterKnife.bind(this);
        ToastUtil.init(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        shopname = bundle.getString("shopname");
        shopid = bundle.getInt("shopid");
        setToolBar();
    }

    private void setToolBar() {
        toolbar.setTitle(shopname);
        // 设置返回按钮图标
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);
        // 添加默认返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // 引用导航菜单布局
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_business, menu);
        return true;
    }

    // 导航按钮点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_call:
                ToastUtil.showToast("电话按钮");
                break;
            case R.id.menu_like:
                ToastUtil.showToast("收藏按钮");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
