package com.example.demo.util;


import android.content.Context;

import com.bumptech.glide.Glide;
import com.example.demo.activity.ShopDetailActivity;
import com.example.demo.okhttp.entity.entity.CommentBean;
import com.example.demo.okhttp.entity.entity.FoodBean;
import com.example.demo.okhttp.entity.entity.TypeBean;

import java.util.ArrayList;
import java.util.List;


public class BaseUtils {

	public static List<TypeBean> getTypes() {

		return ShopDetailActivity.tList;
	}

	public static List<FoodBean> getDatas(Context context) {

		return ShopDetailActivity.fList;
	}

	public static List<FoodBean> getDetails(List<FoodBean> fList) {
		ArrayList<FoodBean> flist = new ArrayList<>();
		for (int i = 1; i < 5; i++) {
			if (fList.size() > i * 10) {
				flist.add(fList.get(i * 10 - 1));
				flist.add(fList.get(i * 10));
			} else {
				break;
			}
		}
		return flist;
	}

	public static List<CommentBean> getComment() {
		ArrayList<CommentBean> cList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			cList.add(new CommentBean());
		}
		return cList;
	}
}
