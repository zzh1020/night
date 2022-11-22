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

import com.example.book.R;
import com.example.book.data.BookDatasource;
import com.example.book.data.MoreDatasource;

import java.util.ArrayList;
import java.util.List;

public class MoreActivity extends AppCompatActivity {
    private TextView morename;
    private ScrollView moresv;
    private TextView morecontent;
    private LinearLayout lnread;
    private Button btntheme;
    private List<Integer> list=new ArrayList<>();
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initView();
        initLisnter();
    }

    private void initView() {
        btntheme=findViewById(R.id.btntheme1);
        morename = findViewById(R.id.morename);
        moresv = findViewById(R.id.moresv);
        morecontent = findViewById(R.id.morecontent);
        lnread=findViewById(R.id.lnread1);
        Intent intent=getIntent();
        list=intent.getIntegerArrayListExtra("id");
        count=intent.getIntExtra("count",337);
            switch (list.get(count)) {
                case 1:
                    morename.setText(BookDatasource.getName(list.get(count)));
                    morecontent.setText(MoreDatasource.moreBook(list.get(count)));
                    break;
                case 2:
                    morename.setText(BookDatasource.getName(list.get(count)));
                    morecontent.setText(MoreDatasource.moreBook(list.get(count)));
                    break;
                case 3:
                    morename.setText(BookDatasource.getName(list.get(count)));
                    morecontent.setText(MoreDatasource.moreBook(list.get(count)));
                    break;
                case 4:
                    morename.setText(BookDatasource.getName(list.get(count)));
                    morecontent.setText(MoreDatasource.moreBook(list.get(count)));
                    break;
                case 5:
                    morename.setText(BookDatasource.getName(list.get(count)));
                    morecontent.setText(MoreDatasource.moreBook(list.get(count)));
                    break;
                case 6:
                    morename.setText(BookDatasource.getName(list.get(count)));
                    morecontent.setText(MoreDatasource.moreBook(list.get(count)));
                    break;
            }

        View childview= moresv.getChildAt(0);
        moresv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(childview.getMeasuredHeight()<=moresv.getScrollY()+moresv.getHeight()){
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(MoreActivity.this);
                    alertDialog.setMessage("书籍观看完毕,返回首页？");
                    alertDialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent1=new Intent(MoreActivity.this,MainActivity.class);
                            startActivity(intent1);
                        }
                    });
                    alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertDialog.show();
                }
                return false;
            }
        });
    }
    public void initLisnter(){
        btntheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MoreActivity.this, view);//第二个参数是绑定的那个view
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