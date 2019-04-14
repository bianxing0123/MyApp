package com.example.demo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.okhttp.entity.entity.ShopInfoEntity;

import java.util.ArrayList;

/**
 * author: GJZ
 * email: 597605602@qq.com
 */
public class ShopFormAdapter extends RecyclerView.Adapter<ShopFormAdapter.myViewHodler> {

    private ArrayList<ShopInfoEntity> mData;

    public ShopFormAdapter(ArrayList<ShopInfoEntity> data) {
        this.mData = data;
    }

//    public void updateData(ArrayList<ShopInfoEntity> data) {
//        this.mData = data;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public myViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 实例化展示的view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shopinfo,viewGroup, false);
        // 实例化viewholder
        myViewHodler viewHolder = new myViewHodler(v);
        return viewHolder;
    }

    /**
     * 绑定数据，数据与view绑定
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull myViewHodler viewHolder, int position) {
        ShopInfoEntity data = mData.get(position);
        viewHolder.image.setImageResource(R.drawable.ali_pay);
        viewHolder.name.setText(data.getShopname());
        viewHolder.sell.setText("1"+data.getSellamount());
        viewHolder.info.setText(data.getSendinfo());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class myViewHodler extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;
        private TextView sell;
        private TextView info;

        public myViewHodler(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.shopInfoPic);
            name = (TextView)itemView.findViewById(R.id.txt_name);
            sell = (TextView)itemView.findViewById(R.id.txt_month_sales);
            info = (TextView)itemView.findViewById(R.id.txt_content);
        }
    }
}
