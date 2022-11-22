package com.example.book.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book.R;
import com.example.book.adpater.BookSqladpater;
import com.example.book.bean.BookList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SQLiteHelp dbhelp;
    private ImageView imgFind;
    private ListView listContent;
    private ImageView imgSaixuan;
    private ImageView imgVip;
    private ImageView imgUser;
    private ImageView imgxiangqi;
    private List<Integer> ids=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListnter();
    }
    private void initView() {
        imgxiangqi=findViewById(R.id.bookxiangqin);
        imgFind = findViewById(R.id.imgFind);
        imgSaixuan = findViewById(R.id.imgSaixuan);
        imgVip = findViewById(R.id.imgVip);
        imgUser = findViewById(R.id.imgUser);
        listContent = findViewById(R.id.listContent);
        dbhelp = new SQLiteHelp(this, "Book.+", null, 1);
        SQLiteDatabase db = dbhelp.getWritableDatabase();
        List<BookList> list = new ArrayList<BookList>();
//        遍历
        Cursor cursor = db.query("book", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                BookList book = new BookList();
                ids.add(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                String bookName = cursor.getString(cursor.getColumnIndexOrThrow("bookName"));
                String author = cursor.getString(cursor.getColumnIndexOrThrow("author"));
                String type = cursor.getString(cursor.getColumnIndexOrThrow("type"));
                int count = cursor.getInt(cursor.getColumnIndexOrThrow("count"));
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setType(type);
                book.setCount(count);
                list.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();
        BookSqladpater adpater = new BookSqladpater(MainActivity.this, R.layout.item_book_layout, list);
        listContent.setAdapter(adpater);
    }
    private void initListnter() {
        listContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, BookCotentActivity.class);
                intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) ids);
                intent.putExtra("count",i);
                startActivity(intent);
            }
        });
        imgxiangqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgxiangqi.setBackgroundResource(R.drawable.huibg);
                imgUser.setBackgroundResource(R.drawable.titlebg);
                imgVip.setBackgroundResource(R.drawable.titlebg);
                imgSaixuan.setBackgroundResource(R.drawable.titlebg);
            }
        });
        imgFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "该功能暂未开放，敬请期待", Toast.LENGTH_SHORT).show();
            }
        });
        imgSaixuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SaixuanActivity.class);
                startActivity(intent);
            }
        });
        imgVip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,VipActivity.class);
                startActivity(intent);
            }
        });
        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });
    }
}