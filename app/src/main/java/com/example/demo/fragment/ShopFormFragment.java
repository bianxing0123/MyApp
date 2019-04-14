package com.example.demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.R;
import com.example.demo.adapter.ShopFormAdapter;
import com.example.demo.okhttp.entity.entity.ShopInfoEntity;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: GJZ
 * email: 597605602@qq.com
 */
public class ShopFormFragment extends Fragment {

    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private View view;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public RecyclerView mRecyclerView;
    //定义以ShopInfoEntity实体类为对象的数据集合
    public ArrayList<ShopInfoEntity> shopsEntityList = new ArrayList<ShopInfoEntity>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //获取fragment的layout
        view = inflater.inflate(R.layout.fragment_shopform, container, false);
        shopsEntityList.clear();
        ButterKnife.bind(this, view);
        //对recycleview进行配置
        initRecyclerView();
        //加载数据
        initData();
        return view;
    }

    private void initData() {
        for (int i=0;i<10;i++){
            ShopInfoEntity shopEntity=new ShopInfoEntity();
            shopEntity.setShopname("Shop"+i);
            shopEntity.setShopImage("mipmap-hdpi/ic_launcher.png");
            shopEntity.setSellamount(i);
            shopEntity.setSendinfo("abc");
            shopsEntityList.add(shopEntity);
        }
    }

    private void initRecyclerView() {
        //ToolBar设置标题
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        toolbar.setTitle(R.string.toolbar_home);
        //获取RecyclerView
        mRecyclerView=(RecyclerView)view.findViewById(R.id.shopForm);
        //创建adapter
        mAdapter = new ShopFormAdapter(shopsEntityList);
        //给RecyclerView设置adapter
        mRecyclerView.setAdapter(mAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.shape_divider));
        //设置item的分割线
        mRecyclerView.addItemDecoration(divider);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        //设置 Header 为 Material风格
        refreshLayout.setRefreshHeader(new MaterialHeader(getActivity()).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        refreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
        //监听事件

    }
}
