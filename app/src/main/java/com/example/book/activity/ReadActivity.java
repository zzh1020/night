package com.example.book.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.book.R;
import com.example.book.data.BookDatasource;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity {
    private LinearLayout lnread;
    private TextView readname;
    private TextView readcontent;
    private ScrollView sv;
    private List<Integer> list=new ArrayList<>();
    private Button btnthem;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        initView();
        initLisnter();
    }

    private void initView() {
        btnthem=findViewById(R.id.btntheme);
        readname = findViewById(R.id.readname);
        readcontent = findViewById(R.id.readcontent);
        sv = findViewById(R.id.sv);
        lnread=findViewById(R.id.lnread);
        Intent intent = getIntent();
        list=intent.getIntegerArrayListExtra("id");
        count=intent.getIntExtra("count",337);
            switch (list.get(count)) {
                case 1:
                    readname.setText(BookDatasource.getName(list.get(count)));
                    readcontent.setText(BookDatasource.getBook(list.get(count)));
                    break;
                case 2:
                    readname.setText(BookDatasource.getName(list.get(count)));
                    readcontent.setText(BookDatasource.getBook(list.get(count)));
                    break;
                case 3:
                    readname.setText(BookDatasource.getName(list.get(count)));
                    readcontent.setText(BookDatasource.getBook(list.get(count)));
                    break;
                case 4:
                    readname.setText(BookDatasource.getName(list.get(count)));
                    readcontent.setText(BookDatasource.getBook(list.get(count)));
                    break;
                case 5:
                    readname.setText(BookDatasource.getName(list.get(count)));
                    readcontent.setText(BookDatasource.getBook(list.get(count)));
                    break;
                case 6:
                    readname.setText(BookDatasource.getName(list.get(count)));
                    readcontent.setText(BookDatasource.getBook(list.get(count)));
                    break;
        }

        View childView=sv.getChildAt(0);
        sv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_UP:
                        if (childView.getMeasuredHeight() <= sv.getScrollY() + sv.getHeight()) {
                            AlertDialog.Builder alertDialog=new AlertDialog.Builder(ReadActivity.this);
                            alertDialog.setTitle("书籍购买");
                            alertDialog.setMessage("体验到此结束啦,想要观看请购买书籍😜");
                            alertDialog.setIcon(R.drawable.shop);
                            alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    onBackPressed();
                                }
                            });
                            alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent1=new Intent(ReadActivity.this,ShopActivity.class);
                                    intent1.putIntegerArrayListExtra("id", (ArrayList<Integer>) list);
                                    intent1.putExtra("count",count);
                                    startActivity(intent1);
                                }
                            });
                            alertDialog.show();
                        }
                        break;
                }
                return false;
            }
        });
    }
    private void initLisnter() {
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(ReadActivity.this, view);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater = popup.getMenuInflater();
                //填充菜单
                inflater.inflate(R.menu.read, popup.getMenu());
                //绑定菜单项的点击事件
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.btnbg1:
                                lnread.setBackgroundColor(Color.rgb(0,255,255));
                                break;
                            case R.id.btnbg2:
                                lnread.setBackgroundColor(Color.rgb(128,128,128));
                                break;
                            case R.id.btnbg3:
                                lnread.setBackgroundColor(Color.rgb(250,215,217));
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                //显示(这一行代码不要忘记了)
                popup.show();
            }
        });
    }
}