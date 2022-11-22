package com.example.book.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book.R;
import com.example.book.bean.VipInfo;
import com.example.book.data.VipDatasource;

import java.util.List;

public class VipActivity extends AppCompatActivity {

    private Button btnback;
    private EditText etname;
    private EditText etpassword;
    private Button btnlogin;
    private TextView tvfindpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        initView();
        initLisnter();
    }
    private void initView() {
        btnback = findViewById(R.id.btnback);
        etname = findViewById(R.id.etname);
        etpassword = findViewById(R.id.etpassword);
        btnlogin = findViewById(R.id.btnlogin);
        tvfindpassword = findViewById(R.id.tvfindpassword);
    }
    private void initLisnter() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<VipInfo> list=VipDatasource.getUser();
                for (int i = 0; i < list.size() ; i++) {
                    if(etname.getText().toString().equals(list.get(i).getUsername())&&etpassword.getText().toString().equals(list.get(i).getPassword())){
                        Intent intent=new Intent(VipActivity.this,VipContentActivity.class);
                        intent.putExtra("name",etname.getText().toString());
                        intent.putExtra("vip",1);
                        startActivity(intent);
                        break;
                    }
                    if(i==list.size()-1){
                        Intent intent=new Intent(VipActivity.this,VipContentActivity.class);
                        intent.putExtra("name",etname.getText().toString());
                        intent.putExtra("vip",0);
                        startActivity(intent);
                        break;
                    }
                    }
                }

        });
    }

}