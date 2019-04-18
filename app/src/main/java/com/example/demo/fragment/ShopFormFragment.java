package com.example.demo.fragment;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.activity.HomeActivity;
import com.example.demo.activity.ShopDetailActivity;
import com.example.demo.adapter.ShopFormAdapter;
import com.example.demo.okhttp.Method;
import com.example.demo.okhttp.entity.entity.ShopInfoEntity;
import com.example.demo.util.ToastUtil;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import java.util.ArrayList;
import java.util.List;

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
    private ShopFormAdapter mAdapter;
    public RecyclerView mRecyclerView;
    //定义以ShopInfoEntity实体类为对象的数据集合
    public ArrayList<ShopInfoEntity> shopsEntityList = new ArrayList<ShopInfoEntity>();
    private Method method;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //获取fragment的layout
        view = inflater.inflate(R.layout.fragment_shopform, container, false);
        //shopsEntityList.clear();
        ButterKnife.bind(this, view);
        ToastUtil.init(getActivity());
        method = new Method();
        //对recycleview进行配置
        initRecyclerView();
        //加载数据
        initData();
        return view;
    }

    private void initData() {
        method.getShopList().subscribe(shopListResponse -> {
            shopsEntityList.clear();
            for (int i=0;i<shopListResponse.shopList.size();i++){
                ShopInfoEntity shopInfoEntity = new ShopInfoEntity();
                shopInfoEntity.setShopinfoid(shopListResponse.shopList.get(i).getShopinfoid());
                shopInfoEntity.setShopname(shopListResponse.shopList.get(i).getShopname());
                shopInfoEntity.setShopsellamount(shopListResponse.shopList.get(i).getShopsellamount());
                shopInfoEntity.setDelivercost(shopListResponse.shopList.get(i).getDelivercost());
                shopInfoEntity.setStartsendprice(shopListResponse.shopList.get(i).getStartsendprice());
                String url = "http://192.168.31.103:9999/MyService/images/"+1+".png";
                shopInfoEntity.setShopImage(url);
                shopsEntityList.add(shopInfoEntity);
            }
            mAdapter.notifyDataSetChanged();
            System.out.println(shopsEntityList);
        });
    }

    private void initRecyclerView() {
        //ToolBar设置标题
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        toolbar.setTitle(R.string.toolbar_home);
        //获取RecyclerView
        mRecyclerView=(RecyclerView)view.findViewById(R.id.shopForm);
        //创建adapter
        mAdapter = new ShopFormAdapter(shopsEntityList,getActivity());
        //给RecyclerView设置adapter
        mAdapter.setOnItemClickListener(new ShopFormAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position, ShopInfoEntity data) {
                ToastUtil.showToast("这个是第"+position+"个位置");
                Intent intent = new Intent(getActivity(),ShopDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("shopid",data.getShopinfoid());
                bundle.putString("shopname",data.getShopname());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.shape_divider));
        //设置item的分割线
        mRecyclerView.addItemDecoration(divider);
        //设置 Header 为 Material风格
        refreshLayout.setRefreshHeader(new MaterialHeader(getActivity()).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        refreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                method.getShopList().subscribe(shopListResponse -> {
                    shopsEntityList.clear();
                    for (int i=0;i<shopListResponse.shopList.size();i++){
                        ShopInfoEntity shopInfoEntity = new ShopInfoEntity();
                        shopInfoEntity.setShopinfoid(shopListResponse.shopList.get(i).getShopinfoid());
                        shopInfoEntity.setShopname(shopListResponse.shopList.get(i).getShopname());
                        shopInfoEntity.setShopsellamount(shopListResponse.shopList.get(i).getShopsellamount());
                        shopInfoEntity.setDelivercost(shopListResponse.shopList.get(i).getDelivercost());
                        shopInfoEntity.setStartsendprice(shopListResponse.shopList.get(i).getStartsendprice());
                        String url = "http://192.168.31.103:9999/MyService/images/"+1+".png";
                        shopInfoEntity.setShopImage(url);
                        shopsEntityList.add(shopInfoEntity);
                    }
                    mAdapter.notifyDataSetChanged();
                    System.out.println(shopsEntityList);
                    refreshlayout.finishRefresh(500);//传入false表示刷新失败
                });
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(500/*,false*/);//传入false表示加载失败
            }
        });
    }
}
