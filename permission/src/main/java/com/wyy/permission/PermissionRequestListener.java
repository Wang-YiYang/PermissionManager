package com.wyy.permission;

/**
 * 作者：王一阳
 * 时间：2016/12/27
 * 描述：
 */

public interface PermissionRequestListener {
    void onRequestResult(String[] deniedPermissions);
}
