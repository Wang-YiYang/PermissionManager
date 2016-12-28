package com.wyy.permission;

import android.Manifest;

/**
 * 作者：王一阳
 * 时间：2016/12/27
 * 描述：危险权限
 */

public class Permissions {

    /**
     * 读取手机内存卡相关权限
     */
    public static final String GROUP_STORAGE = Manifest.permission_group.STORAGE;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;

    /**
     * 通讯录相关权限
     */
    public static final String GROUP_CONTACTS = Manifest.permission_group.CONTACTS;
    public static final String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static final String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    public static final String READ_CONTACTS = Manifest.permission.READ_CONTACTS;

    /**
     * 拨打电话相关权限
     */
    public static final String GROUP_PHONE = Manifest.permission_group.PHONE;
    public static final String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    public static final String USE_SIP = Manifest.permission.USE_SIP;
    public static final String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    public static final String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;

    /**
     * 日历相关权限
     */
    public static final String GROUP_CALENDAR = Manifest.permission_group.CALENDAR;
    public static final String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public static final String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;

    /**
     * 相机相关权限
     */
    public static final String GROUP_CAMERA = Manifest.permission_group.CAMERA;
    public static final String CAMERA = Manifest.permission.CAMERA;

    /**
     * 传感器相关权限
     */
    public static final String GROUP_SENSORS = Manifest.permission_group.SENSORS;
    public static final String BODY_SENSORS = Manifest.permission.BODY_SENSORS;

    /**
     * 定位相关权限
     */
    public static final String GROUP_LOCATION = Manifest.permission_group.LOCATION;
    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;


    /**
     * 话筒相关权限
     */
    public static final String GROUP_MICROPHONE = Manifest.permission_group.MICROPHONE;
    public static final String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;

    /**
     * 短信相关权限
     */
    public static final String GROUP_SMS = Manifest.permission_group.SMS;
    public static final String READ_SMS = Manifest.permission.READ_SMS;
    public static final String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public static final String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
    public static final String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static final String SEND_SMS = Manifest.permission.SEND_SMS;
//    public static final String READ_CELL_BROADCASTS = Manifest.permission.READ_CELL_BROADCASTS;

}
