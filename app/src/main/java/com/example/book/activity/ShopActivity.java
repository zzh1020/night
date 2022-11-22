package com.example.book.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.book.R;
import com.example.book.data.ShopDatasource;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    private TextView yuer;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox shopchek1;
    private CheckBox shopchek2;
    private CheckBox shopchek3;
    private CheckBox shopchek4;
    private CheckBox shopchek5;
    private CheckBox shopchek6;
    private TextView readbookprice;
    private Button backshop;
    private Button shop;
    private int bookmoney;
    private List<Integer> list=new ArrayList<>();
    private int count;
    private SQLiteHelp sqLiteHelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();
        initLisnter();
    }
    private void initView() {
        shop=findViewById(R.id.shop);
        yuer = findViewById(R.id.yuer);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        shopchek1 = findViewById(R.id.shopchek1);
        shopchek2 = findViewById(R.id.shopchek2);
        shopchek3 = findViewById(R.id.shopchek3);
        shopchek4 = findViewById(R.id.shopchek4);
        shopchek5 = findViewById(R.id.shopchek5);
        shopchek6 = findViewById(R.id.shopchek6);
        readbookprice = findViewById(R.id.readbookprice);
        backshop = findViewById(R.id.backshop);
        Intent intent=getIntent();
        list=intent.getIntegerArrayListExtra("id");
        count=intent.getIntExtra("count",337);
        yuer.setText("余额："+ShopDatasource.getShubi(0)+"书苑币");
            switch (list.get(count)) {
                case 1:
                    readbookprice.setText(ShopDatasource.getbookprice(list.get(count)));
                    bookmoney=39;
                    break;
                case 2:
                    readbookprice.setText(ShopDatasource.getbookprice(list.get(count)));
                    bookmoney=49;
                    break;
                case 3:
                    readbookprice.setText(ShopDatasource.getbookprice(list.get(count)));
                    bookmoney=79;
                    break;
                case 4:
                    readbookprice.setText(ShopDatasource.getbookprice(list.get(count)));
                    bookmoney=69;
                    break;
                case 5:
                    readbookprice.setText(ShopDatasource.getbookprice(list.get(count)));
                    bookmoney=19;
                    break;
                case 6:
                    readbookprice.setText(ShopDatasource.getbookprice(list.get(count)));
                    bookmoney=29;
                    break;
            }
    }
    private void initLisnter() {
        backshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!shopchek1.isChecked()||!shopchek2.isChecked()||!shopchek3.isChecked()||!shopchek4.isChecked()||!shopchek5.isChecked()||!shopchek6.isChecked())&&bookmoney>ShopDatasource.getShubi(0)) {
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ShopActivity.this);
                    alertDialog.setIcon(R.drawable.querenzhongzhi);
                    alertDialog.setTitle("购买信息");
                    alertDialog.setMessage("余额不足,确认充值嘛🤑");
                    alertDialog.setPositiveButton("确认😁", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    alertDialog.setNegativeButton("取消😒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            onBackPressed();
                        }
                    });
                    alertDialog.show();
                }
                if ((!shopchek1.isChecked()||!shopchek2.isChecked()||!shopchek3.isChecked()||!shopchek4.isChecked()||!shopchek5.isChecked()||!shopchek6.isChecked())&&bookmoney<=ShopDatasource.getShubi(0)) {
                    yuer.setText("余额:"+(50-bookmoney)+"书苑币");
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ShopActivity.this);
                    alertDialog.setIcon(R.drawable.chongzhi);
                    alertDialog.setTitle("购买信息");
                    alertDialog.setMessage("购买成功,继续观看");
                    alertDialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sql();
                            Intent intent=new Intent(ShopActivity.this,MoreActivity.class);
                            intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) list);
                             intent.putExtra("count",count);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
                if(shopchek1.isChecked()&&bookmoney>(100+50)){
                    Toast.makeText(ShopActivity.this, "可用余额不足,请进行充值", Toast.LENGTH_SHORT).show();
                }
                if(shopchek1.isChecked()&&bookmoney<=(100+50)){
                    yuer.setText("余额:"+(ShopDatasource.getShubi(100)-bookmoney)+"书苑币");
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ShopActivity.this);
                    alertDialog.setIcon(R.drawable.chongzhi);
                    alertDialog.setTitle("购买信息");
                    alertDialog.setMessage("购买成功,继续观看");
                    alertDialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sql();
                            Intent intent=new Intent(ShopActivity.this,MoreActivity.class);
                            intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) list);
                             intent.putExtra("count",count);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
                if(shopchek2.isChecked()&&bookmoney>(150+50)){
                    Toast.makeText(ShopActivity.this, "可用余额不足,请进行充值", Toast.LENGTH_SHORT).show();
                }
                if(shopchek2.isChecked()&&bookmoney<=(150+50)){
                    yuer.setText("余额:"+(ShopDatasource.getShubi(150)-bookmoney)+"书苑币");
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ShopActivity.this);
                    alertDialog.setIcon(R.drawable.chongzhi);
                    alertDialog.setTitle("购买信息");
                    alertDialog.setMessage("购买成功,继续观看");
                    alertDialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sql();
                            Intent intent=new Intent(ShopActivity.this,MoreActivity.class);
                            intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) list);
                             intent.putExtra("count",count);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
                if(shopchek3.isChecked()&&bookmoney>(200+50)){
                    Toast.makeText(ShopActivity.this, "可用余额不足,请进行充值", Toast.LENGTH_SHORT).show();
                }
                if(shopchek3.isChecked()&&bookmoney<=(200+50)){
                    yuer.setText("余额:"+(ShopDatasource.getShubi(100)-bookmoney)+"书苑币");
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ShopActivity.this);
                    alertDialog.setIcon(R.drawable.chongzhi);
                    alertDialog.setTitle("购买信息");
                    alertDialog.setMessage("购买成功,继续观看");
                    alertDialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sql();
                            Intent intent=new Intent(ShopActivity.this,MoreActivity.class);
                            intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) list);
                             intent.putExtra("count",count);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
                if(shopchek4.isChecked()&&bookmoney>(300+50)){
                    Toast.makeText(ShopActivity.this, "可用余额不足,请进行充值", Toast.LENGTH_SHORT).show();
                }
                if(shopchek4.isChecked()&&bookmoney<=(100+50)){
                    yuer.setText("余额:"+(ShopDatasource.getShubi(300)-bookmoney)+"书苑币");
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ShopActivity.this);
                    alertDialog.setIcon(R.drawable.chongzhi);
                    alertDialog.setTitle("购买信息");
                    alertDialog.setMessage("购买成功,继续观看");
                    alertDialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sql();
                            Intent intent=new Intent(ShopActivity.this,MoreActivity.class);
                            intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) list);
                             intent.putExtra("count",count);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
                if(shopchek5.isChecked()&&bookmoney>(400+50)){
                    Toast.makeText(ShopActivity.this, "可用余额不足,请进行充值", Toast.LENGTH_SHORT).show();
                }
                if(shopchek5.isChecked()&&bookmoney<=(400+50)){
                    yuer.setText("余额:"+(ShopDatasource.getShubi(400)-bookmoney)+"书苑币");
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ShopActivity.this);
                    alertDialog.setIcon(R.drawable.chongzhi);
                    alertDialog.setTitle("购买信息");
                    alertDialog.setMessage("购买成功,继续观看");
                    alertDialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sql();
                            Intent intent=new Intent(ShopActivity.this,MoreActivity.class);
                            intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) list);
                             intent.putExtra("count",count);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }
                if(shopchek6.isChecked()&&bookmoney>(500+50)){
                    Toast.makeText(ShopActivity.this, "可用余额不足,请进行充值", Toast.LENGTH_SHORT).show();
                }
                if(shopchek6.isChecked()&&bookmoney<=(500+50)){
                    yuer.setText("余额:"+(ShopDatasource.getShubi(500)-bookmoney)+"书苑币");
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(ShopActivity.this);
                    alertDialog.setIcon(R.drawable.chongzhi);
                    alertDialog.setTitle("购买信息");
                    alertDialog.setMessage("购买成功,继续观看");
                    alertDialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sql();
                            Intent intent=new Intent(ShopActivity.this,MoreActivity.class);
                            intent.putIntegerArrayListExtra("id", (ArrayList<Integer>) list);
                             intent.putExtra("count",count);
                            startActivity(intent);
                        }
                    });
                    alertDialog.show();
                }


            }
        });
    }
    public void sql(){
        sqLiteHelp=new SQLiteHelp(this,"Book.db",null,1);
        SQLiteDatabase db=sqLiteHelp.getWritableDatabase();
        Cursor cursor=db.query("book",null,"id=?",new String[]{String.valueOf(list.get(count))},null,null,null);
        if (cursor.moveToFirst()) {
            do {
                ContentValues values=new ContentValues();
                values.put("book",cursor.getString(cursor.getColumnIndexOrThrow("bookName")));
                db.insert("shoped",null,values);
            }while (cursor.moveToNext());
        }
        cursor.close();
    }
}