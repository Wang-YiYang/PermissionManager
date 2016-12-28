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

        
        //得到被拒绝的权限
        boolean is = p.isNoAsk(deniedPermissions);//权限被拒绝并且不在询问的情况
        if (is) {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent.setData(uri);
            startActivity(intent);
        }
    }

    PermissionManage p;

    @Override
    public void onClick(View v) {
        String[] permissions = {Permissions.CAMERA, Permissions.ACCESS_COARSE_LOCATION, Permissions.READ_SMS};
        p = new PermissionManage(this);
        p.startRequest(permissions, this);
    }
}
