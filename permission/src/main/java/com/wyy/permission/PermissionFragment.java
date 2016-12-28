package com.wyy.permission;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：王一阳
 * 时间：2016/12/27
 * 描述：
 */

public class PermissionFragment extends Fragment {
    public final int PERMISSION_REQUEST_CODE = 0;
    private PermissionRequestListener mListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setReenterTransition(true);
    }

    /**
     * 时间：2016/12/27 22:42
     * 描述：发起请求
     */
    public void requestPermissions(String[] permissions, PermissionRequestListener listener) {
        mListener = listener;
        requestPermissions(permissions, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        List<String> deniedList = new ArrayList<>();
        for (int i = 0, size = permissions.length; i < size; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                //统计被拒绝的权限
                deniedList.add(permissions[i]);
            }
        }
        String[] strs = new String[deniedList.size()];
        mListener.onRequestResult(deniedList.toArray(strs));
    }
}
