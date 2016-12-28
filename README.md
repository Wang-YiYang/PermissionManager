# PermissionManager Android 6.0 权限

简化了对运行时权限处理的操作，使用方便简单

### 1. 在对应的界面实现PermissionRequestListener接口
```Android
public class MainActivity extends AppCompatActivity implements PermissionRequestListener{}
```

### 2. 重写onRequestResult(String[] deniedPermissions)方法
  ```Android
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
```

### 3. 开始请求权限
```Android
       //定义请求的权限数组
       String[] permissions = {Permissions.CAMERA, Permissions.ACCESS_COARSE_LOCATION, Permissions.READ_SMS};
       //创建对象
       p = new PermissionManage(this);
       //开始请求
       p.startRequest(permissions, this);
```
