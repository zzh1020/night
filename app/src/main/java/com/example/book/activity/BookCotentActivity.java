package com.example.book.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book.R;
import com.example.book.data.BookDatasource;

import java.util.ArrayList;
import java.util.List;

public class BookCotentActivity extends AppCompatActivity {
    private TextView tvBookname;
    private ImageView bookImg;
    private TextView bookpublishdate;
    private TextView bookuser;
    private TextView tvContent;
    private Button btnback;
    private Button btnstartread;
    private List<Integer> list=new ArrayList<>();
    private int count;
    int imgs[]=new int[]{R.drawable.luo,R.drawable.dou,R.drawable.longzu,R.drawable.chunshui,R.drawable.santi,R.drawable.bei};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_cotent);
        initView();
        initListenter();
    }

    private void initView() {
        tvBookname = findViewById(R.id.tv_bookname);
        bookImg = findViewById(R.id.bookImg);
        bookpublishdate = findViewById(R.id.bookpublishdate);
        bookuser = findViewById(R.id.bookuser);
        tvContent = findViewById(R.id.tvContent);
        btnback = findViewById(R.id.btnback);
        btnstartread = findViewById(R.id.btnstartread);
        Intent intent=getIntent();
        list=intent.getIntegerArrayListExtra("id");
        count=intent.getIntExtra("count",337);
//        a=intent.getIntExtra("id",337);
            switch (list.get(count)) {
                case 1:
                    tvBookname.setText(BookDatasource.getName(list.get(count)));
                    bookImg.setImageResource(imgs[list.get(count)-1]);
                    bookpublishdate.setText(BookDatasource.getTime(list.get(count)));
                    bookuser.setText(BookDatasource.getUser(list.get(count)));
                    tvContent.setText(BookDatasource.getJianjie(list.get(count)));
                    break;
                case 2:
                    tvBookname.setText(BookDatasource.getName(list.get(count)));
                    bookImg.setImageResource(imgs[list.get(count)-1]);
                    bookpublishdate.setText(BookDatasource.getTime(list.get(count)));
                    bookuser.setText(BookDatasource.getUser(list.get(count)));
                    tvContent.setText(BookDatasource.getJianjie(list.get(count)));
                    break;
                case 3:
                    tvBookname.setText(BookDatasource.getName(list.get(count)));
                    bookImg.setImageResource(imgs[list.get(count)-1]);
                    bookpublishdate.setText(BookDatasource.getTime(list.get(count)));
                    bookuser.setText(BookDatasource.getUser(list.get(count)));
                    tvContent.setText(BookDatasource.getJianjie(list.get(count)));
                    break;
                case 4:
                    tvBookname.setText(BookDatasource.getName(list.get(count)));
                    bookImg.setImageResource(imgs[list.get(count)-1]);
                    bookpublishdate.setText(BookDatasource.getTime(list.get(count)));
                    bookuser.setText(BookDatasource.getUser(list.get(count)));
                    tvContent.setText(BookDatasource.getJianjie(list.get(count)));
                    break;
                case 5:
                    tvBookname.setText(BookDatasource.getName(list.get(count)));
                    bookImg.setImageResource(imgs[list.get(count)-1]);
                    bookpublishdate.setText(BookDatasource.getTime(list.get(count)));
                    bookuser.setText(BookDatasource.getUser(list.get(count)));
                    tvContent.setText(BookDatasource.getJianjie(list.get(count)));
                    break;
                case 6:
                    tvBookname.setText(BookDatasource.getName(list.get(count)));
                    bookImg.setImageResource(imgs[list.get(count)-1]);
                    bookpublishdate.setText(BookDatasource.getTime(list.get(count)));
                    bookuser.setText(BookDatasource.getUser(list.get(count)));
                    tvContent.setText(BookDatasource.getJianjie(list.get(count)));
                    break;
            }

    }
    private void initListenter() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnstartread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BookCotentActivity.this,ReadActivity.class);
                intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) list);
                intent.putExtra("count",count);
                startActivity(intent);
            }
        });
    }
}