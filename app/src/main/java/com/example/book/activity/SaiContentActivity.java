package com.example.book.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book.R;
import com.example.book.adpater.BookSqladpater;
import com.example.book.bean.BookList;

import java.util.ArrayList;
import java.util.List;

public class SaiContentActivity extends AppCompatActivity {

    private ListView saiContent;
    private SQLiteHelp sqLiteHelp;
    private ImageView saiBack;
    private List<Integer> ids=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sai_content);
        initView();
        initLister();
    }


    private void initView() {
        saiContent = findViewById(R.id.saiContent);
        saiBack = findViewById(R.id.saiBack);
        sql();
    }

    private void sql() {
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        List<BookList> list = new ArrayList<BookList>();
        sqLiteHelp = new SQLiteHelp(this, "Book.db", null, 1);
        SQLiteDatabase db = sqLiteHelp.getWritableDatabase();
        Cursor cursor = db.query("book", null, "type=?", new String[]{type}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                BookList book = new BookList();
                ids.add(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                String bookName = cursor.getString(cursor.getColumnIndexOrThrow("bookName"));
                String author = cursor.getString(cursor.getColumnIndexOrThrow("author"));
                String type1 = cursor.getString(cursor.getColumnIndexOrThrow("type"));
                int count = cursor.getInt(cursor.getColumnIndexOrThrow("count"));
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setType(type1);
                book.setCount(count);
                list.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();
        BookSqladpater bookSqladpater = new BookSqladpater(this, R.layout.item_book_layout, list);
        saiContent.setAdapter(bookSqladpater);
    }
    private void initLister() {
        saiBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SaiContentActivity.this,SaixuanActivity.class);
                startActivity(intent);
            }
        });
        saiContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(SaiContentActivity.this,BookCotentActivity.class);
                intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) ids);
                intent.putExtra("count",i);
                startActivity(intent);
            }
        });
    }


}