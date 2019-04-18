package com.example.demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.R;
import com.example.demo.okhttp.entity.entity.ShopInfoEntity;

import java.util.ArrayList;

/**
 * author: GJZ
 * email: 597605602@qq.com
 */
public class ShopFormAdapter extends RecyclerView.Adapter<ShopFormAdapter.myViewHodler> implements View.OnClickListener{

    private Context context;
    private RecyclerView recyclerView;
    private ArrayList<ShopInfoEntity> mData;

    public ShopFormAdapter(ArrayList<ShopInfoEntity> data,Context context) {
        this.mData = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 实例化展示的view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shopinfo,viewGroup, false);
        // 实例化viewholder
        myViewHodler viewHolder = new myViewHodler(v);
        v.setOnClickListener(this);
        return viewHolder;
    }

    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(RecyclerView parent,View view, int position, ShopInfoEntity data);
    }

    @Override
    public void onClick(View view) {
        //根据RecyclerView获得当前View的位置
        int position = recyclerView.getChildAdapterPosition(view);
        //程序执行到此，会去执行具体实现的onItemClick()方法
        if (mOnItemClickListener!=null){
            mOnItemClickListener.onItemClick(recyclerView,view,position,mData.get(position));
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
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
        Glide.with(context).load(data.getShopImage()).into(viewHolder.image);
        viewHolder.name.setText(data.getShopname());
        viewHolder.sell.setText("销售量："+String.valueOf(data.getShopsellamount()));
        viewHolder.info.setText("起送："+data.getStartsendprice()
                +"￥ 配送："+data.getDelivercost()
                +"￥ 平均"+20+"分钟");
    }

    /**
     *   将RecycleView附加到Adapter上
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView= recyclerView;
    }
    /**
     *   将RecycleView从Adapter解除
     */
    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
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
