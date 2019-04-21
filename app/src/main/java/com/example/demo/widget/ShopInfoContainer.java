package com.example.demo.widget;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.activity.ShopDetailActivity;
import com.example.demo.fragment.ShopFormFragment;
import com.example.demo.util.ViewUtils;
import com.facebook.drawee.view.SimpleDraweeView;

public class ShopInfoContainer extends RelativeLayout {

    public TextView shop_name, shop_sum, shop_type, shop_send;
    private ImageView shop_arrow;
    public SimpleDraweeView iv_shop;

    public ShopInfoContainer(Context context) {
        super(context);
    }

    public ShopInfoContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.view_shopinfo, this);
        shop_name = findViewById(R.id.tv_shop_name);
        shop_arrow = findViewById(R.id.tv_shop_arrow);
        shop_sum = findViewById(R.id.tv_shop_summary);
        shop_type = findViewById(R.id.tv_shop_type);
        shop_send = findViewById(R.id.tv_shop_send);
        ViewUtils.getBlurFresco(context, (SimpleDraweeView) findViewById(R.id.iv_shop_bg), "http://192.168.31.103:9999/MyService/images/1.png");
        iv_shop = findViewById(R.id.iv_shop);
        ViewUtils.getFrescoController(context, iv_shop, "http://192.168.31.103:9999/MyService/images/1.png", 40, 40);
        shop_name.setText(ShopFormFragment.shopname);
    }


    public void setWgAlpha(float alpha) {
        shop_sum.setAlpha(alpha);
        shop_arrow.setAlpha(alpha);
        shop_sum.setAlpha(alpha);
        shop_type.setAlpha(alpha);
        shop_send.setAlpha(alpha);
        iv_shop.setAlpha(alpha);
    }
}
