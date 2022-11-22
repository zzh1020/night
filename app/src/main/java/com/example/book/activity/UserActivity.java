package com.example.book.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book.R;
import com.example.book.adpater.ShopedAdpater;
import com.example.book.bean.Shop;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private Button btnshoped;
    private ListView listshoped;
    private SQLiteHelp sqLiteHelp;
    private List<Shop> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initView();
        initListener();
    }
    private void initView() {
        btnshoped = findViewById(R.id.btnshoped);
        listshoped = findViewById(R.id.listshoped);
    }
    private void initListener() {
        btnshoped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteHelp = new SQLiteHelp(UserActivity.this, "Book.db", null, 1);
                SQLiteDatabase db=sqLiteHelp.getWritableDatabase();
                Cursor cursor=db.query("shoped",null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        Shop shop=new Shop();
                        shop.setBook(cursor.getString(cursor.getColumnIndexOrThrow("book")));
                        list.add(shop);
                    }while (cursor.moveToNext());
                }
                cursor.close();
                ShopedAdpater adpater=new ShopedAdpater(UserActivity.this,R.layout.item_shoped_layout,list);
                listshoped.setAdapter(adpater);
            }
        });
    }
}