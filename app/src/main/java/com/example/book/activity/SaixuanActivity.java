package com.example.book.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book.R;

public class SaixuanActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnxuan;
    private Button btnshen;
    private Button btnqin;
    private Button btnke;
    private Button btnsan;
    private String type;
    private Button btnsaiback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saixuan);
        initView();
    }

    private void initView() {
        btnxuan = findViewById(R.id.btnxuan);
        btnshen = findViewById(R.id.btnshen);
        btnqin = findViewById(R.id.btnqin);
        btnke = findViewById(R.id.btnke);
        btnsan = findViewById(R.id.btnsan);
        btnsaiback = findViewById(R.id.btnsaiback);
        btnxuan.setOnClickListener(this);
        btnke.setOnClickListener(this);
        btnsan.setOnClickListener(this);
        btnqin.setOnClickListener(this);
        btnshen.setOnClickListener(this);
        btnsaiback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnxuan:
                go("玄幻");
                break;
            case R.id.btnqin:
                go("青春文学");
                break;
            case R.id.btnke:
                go("科幻");
                break;
            case R.id.btnsan:
                go("散文");
                break;
            case R.id.btnshen:
                go("神话");
                break;
            case R.id.btnsaiback:
                Intent intent = new Intent(SaixuanActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void go(String type) {
        Intent intent = new Intent(SaixuanActivity.this, SaiContentActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }
}