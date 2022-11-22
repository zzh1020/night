package com.example.book.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.book.R;
import com.example.book.adpater.GuideViewAdpater;
import com.example.book.bean.BookList;

import java.util.ArrayList;
import java.util.List;

public class GuideViewActivity extends AppCompatActivity {
    private ViewPager guideView;
    private List<View> views=new ArrayList<>();
    private CountDownTimer timer;
    int imgs[]=new int[]{R.drawable.one,R.drawable.two,R.drawable.three};
    private  int time=1;
    private ImageView iv;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(time<=3){
//                iv=new ImageView(GuideViewActivity.this);
//                iv.setBackgroundResource(imgs[time-1]);
//                views.add(iv);
//                GuideViewAdpater adapter=new GuideViewAdpater(views);
//                guideView.setAdapter(adapter);
                guideView.setCurrentItem(time-1);
                time++;
                handler.sendEmptyMessageDelayed(100,2000);
            }else {
                Intent intent=new Intent(GuideViewActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_view);
        initView();
        handler.sendEmptyMessage(100);
    }

    private void initView() {
        guideView = findViewById(R.id.guideView);
        for (int i = 0; i < imgs.length; i++) {
            iv=new ImageView(this);
            iv.setBackgroundResource(imgs[i]);
            views.add(iv);
            if (i==imgs.length-1) {
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(GuideViewActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        GuideViewAdpater adapter=new GuideViewAdpater(views);
        guideView.setAdapter(adapter);
    }


}