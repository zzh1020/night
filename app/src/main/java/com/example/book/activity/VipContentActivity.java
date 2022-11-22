package com.example.book.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.book.R;

public class VipContentActivity extends AppCompatActivity {

    private TextView textvipname;
    private TextView vipdengji;
    private ImageView imgVipback;
    private ImageView imgkefu;
    private ImageView imgour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_content);
        initView();

    }

    private void initView() {
        textvipname = findViewById(R.id.textvipname);
        vipdengji = findViewById(R.id.vipdengji);
        imgkefu = findViewById(R.id.imgkefu);
        imgour = findViewById(R.id.imgour);
        imgVipback = findViewById(R.id.imgVipback);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int a = intent.getIntExtra("vip", 337);
        switch (a) {
            case 1:
                textvipname.setText("昵称：" + name);
                vipdengji.setText("你当前的用户等级为：VIP✨");
                break;
            case 0:
                textvipname.setText("昵称：" + name);
                vipdengji.setText("你当前的用户等级为：抱歉你还不是会员,请联系管理员为你开通哦😜");
                break;
        }
        imgVipback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(VipContentActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        imgkefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((ContextCompat.checkSelfPermission(VipContentActivity.this, Manifest.permission.CALL_PHONE)!=
                        PackageManager.PERMISSION_GRANTED)) {
                    ActivityCompat.requestPermissions(VipContentActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }else {
                    call();
                }
            }
        });
        imgour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(VipContentActivity.this);
                alertDialog.setTitle("关于我们");
                alertDialog.setMessage("书香苑是全球领先的ICT（信息与通信）基础设施和智能终端提供商，" +
                        "致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界。我们在通信网络、" +
                        "IT、智能终端和云服务等领域为客户提供有竞争力、安全可信赖的产品、解决方案与服务，与生态伙伴开放合作" +
                        "，持续为客户创造价值，释放个人潜能，丰富家庭生活，激发组织创新。华为坚持围绕客户需求持续创新，" +
                        "加大基础研究投入，厚积薄发，推动世界进步");
                alertDialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
            }
        });

    }
    private void call(){
        try {
            Intent intent1=new Intent(Intent.ACTION_CALL);
            intent1.setData(Uri.parse("tel:18528264964"));
//            intent1.setData(Uri.parse("tel:18163871815"));
            startActivity(intent1);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(this, "你拒绝了该权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}