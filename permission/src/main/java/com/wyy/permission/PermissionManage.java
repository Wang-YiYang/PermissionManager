package com.wyy.permission;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：王一阳
 * 时间：2016/12/27
 * 描述：
 */

public class PermissionManage {

    private final String TAG = "permission";
    private AppCompatActivity mActivity;

    private PermissionFragment mPermissionFragment;

    public PermissionManage(@NonNull AppCompatActivity activity) {
        mActivity = activity;
        mPermissionFragment = getFragment();
    }

    /**
     * 时间：2016/12/27 22:45
     * 描述：请求权限
     */
    public void startRequest(String[] permissions, @NonNull PermissionRequestListener listener) {
        requestPermissions(listener, permissions);
    }

    /**
     * 时间：2016/12/28 21:04
     * 描述：是否拒绝了权限，并设置了不在提示
     */
    public boolean isNoAsk(String[] permissions) {
        for (int i = 0; i < permissions.length; i++) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(mActivity, permissions[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间：2016/12/27 18:58
     * 描述：获取未被授予的权限
     */
    private List<String> getNoPermissions(String[] permissions) {
        List<String> permissionList = new ArrayList<>();
        for (String p : permissions) {
            if (isDenied(p)) {
                permissionList.add(p);
            }
        }
        return permissionList;
    }

    /**
     * 时间：2016/12/27 19:18
     * 描述：把请求的权限传到Fragment进行处理
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    private void requestPermissions(@NonNull PermissionRequestListener listener, String[] permissions) {

        List<String> permissionList = getNoPermissions(permissions);
        if (permissionList.size() > 0) {
            String[] strs = new String[permissionList.size()];
            mPermissionFragment.requestPermissions(permissionList.toArray(strs), listener);
        }
    }

    /**
     * 时间：2016/12/27 22:26
     * 描述：实例化Fragment,并且放入activity中
     */
    private PermissionFragment getFragment() {
        PermissionFragment permissionFragment = findPermissionFragment(mActivity);
        boolean isNewInstance = permissionFragment == null;
        if (isNewInstance) {
            permissionFragment = new PermissionFragment();
            FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(permissionFragment, TAG)
                    .commit();
            fragmentManager.executePendingTransactions();
        }
        return permissionFragment;
    }

    /**
     * 时间：2016/12/27 22:26
     * 描述：根据Tag找到已经存在的Fragment
     */
    private PermissionFragment findPermissionFragment(AppCompatActivity activity) {
        return (PermissionFragment) activity.getSupportFragmentManager().findFragmentByTag(TAG);
    }

    /**
     * 时间：2016/12/27 19:07
     * 描述：判断该权限是否为授予
     * PackageManager.PERMISSION_GRANTED 授予权限
     * PackageManager.PERMISSION_DENIED 缺少权限
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    private boolean isDenied(String permission) {
        return ContextCompat.checkSelfPermission(mActivity, permission)
                == PackageManager.PERMISSION_DENIED;
    }

}
