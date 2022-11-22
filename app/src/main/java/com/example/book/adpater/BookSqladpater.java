package com.example.book.adpater;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.book.R;
import com.example.book.bean.BookList;

import java.util.List;

public class BookSqladpater extends BaseAdapter {
    private Context context;
    private int rskayout;
    private List<BookList> data;

    public BookSqladpater(Context context, int rskayout, List<BookList> data) {
        this.context = context;
        this.rskayout = rskayout;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1;
        ViewHolder viewHolder;
        if (view==null){
            view1=LayoutInflater.from(context).inflate(rskayout,viewGroup,false);
            viewHolder=new ViewHolder();
            viewHolder.tv_name=view1.findViewById(R.id.tv_name);
            viewHolder.tv_user=view1.findViewById(R.id.tv_user);
            viewHolder.tv_type=view1.findViewById(R.id.tv_type);
            viewHolder.tv_count=view1.findViewById(R.id.tv_count);
            view1.setTag(viewHolder);
        }else {
            view1=view;
            viewHolder= (ViewHolder) view1.getTag();
        }
        viewHolder.tv_name.setText(((BookList) getItem(i)).getBookName());
        viewHolder.tv_user.setText(((BookList) getItem(i)).getAuthor());
        viewHolder.tv_count.setText("章节数:"+((BookList) getItem(i)).getCount()+"");
        viewHolder.tv_type.setText("类型:"+((BookList) getItem(i)).getType());
        return view1;
    }
    class ViewHolder{
         TextView tv_name;
         TextView tv_user;
         TextView tv_type;
         TextView tv_count;
    }
}
