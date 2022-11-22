package com.example.book.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.book.R;
import com.example.book.bean.BookList;
import com.example.book.bean.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopedAdpater extends BaseAdapter {
    private Context context;
    private int reslayout;
    private List<Shop> list;

    public ShopedAdpater(Context context, int reslayout, List<Shop> list) {
        this.context = context;
        this.reslayout = reslayout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewshop;
        ViewHolder viewHolder;
        if (view==null) {
            viewshop= LayoutInflater.from(context).inflate(reslayout,viewGroup,false);
            viewHolder=new ViewHolder();
            viewHolder.tv_book=viewshop.findViewById(R.id.shopbookname);
            viewshop.setTag(viewHolder);
        }else {
            viewshop=view;
            viewHolder= (ViewHolder) viewshop.getTag();
        }
        viewHolder.tv_book.setText(((Shop) getItem(i)).getBook());
        return viewshop;
    }
    class ViewHolder {
      TextView tv_book;
    }
}

