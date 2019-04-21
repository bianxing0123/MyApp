package com.example.demo.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.demo.R;
import com.example.demo.adapter.ViewPagerAdapter;
import com.example.demo.fragment.ShopFormFragment;
import com.example.demo.fragment.TestFragment;
import com.example.demo.okhttp.Method;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private MenuItem menuItem;
    private Method method;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        method = new Method();
        initData();
        initView();
    }

    private void initData() {
    }

    private void initView() {
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        viewPager = (ViewPager) findViewById(R.id.vp);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        List<Fragment> list = new ArrayList<>();
        list.add(new ShopFormFragment());
        list.add(TestFragment.newInstance("订单"));
        list.add(TestFragment.newInstance("我的"));
        viewPagerAdapter.setList(list);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            menuItem = item;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_order:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_me:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
}
