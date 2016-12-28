package com.wyy.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wyy.permission.PermissionManage;
import com.wyy.permission.PermissionRequestListener;
import com.wyy.permission.Permissions;


public class MainActivity extends AppCompatActivity implements PermissionRequestListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onRequestResult(String[] deniedPermissions) {
        /*
         *在此方法中写权限申请后对应的逻辑操作
         */

        //得到被拒绝的权限
        boolean is = p.isNoAsk(deniedPermissions);//权限被拒绝并且不在询问的情况
        if (is) {
            //跳转到设置界面，这里是测试代码，对应需求对应处理
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent.setData(uri);
            startActivity(intent);
        }
    }

    PermissionManage p;

    @Override
    public void onClick(View v) {
        //定义请求的权限数组
        String[] permissions = {Permissions.CAMERA, Permissions.ACCESS_COARSE_LOCATION, Permissions.READ_SMS};
        //创建对象
        p = new PermissionManage(this);
        //开始请求
        p.startRequest(permissions, this);
    }
}
