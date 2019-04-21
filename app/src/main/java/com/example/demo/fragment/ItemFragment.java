package com.example.demo.fragment;

import android.os.Bundle;

import com.example.demo.R;
import com.example.demo.activity.ShopDetailActivity;
import com.example.demo.adapter.FoodAdapter;
import com.example.demo.adapter.TypeAdapter;
import com.example.demo.widget.ListContainer;
import com.shizhefei.fragment.LazyFragment;

/**
 * author: GJZ
 * email: 597605602@qq.com
 */
public class ItemFragment extends LazyFragment {

    private ListContainer listContainer;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_shopdetail);
        listContainer = (ListContainer) findViewById(R.id.listcontainer);
        listContainer.setAddClick((ShopDetailActivity)getActivity());
    }

    public FoodAdapter getFoodAdapter() {
        return listContainer.foodAdapter;
    }

    public TypeAdapter getTypeAdapter() {
        return listContainer.typeAdapter;
    }
}
