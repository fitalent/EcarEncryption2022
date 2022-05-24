package com.ecar.encryption.RoadPark;

import com.ecar.encryption.base.EncryUtilImpl;

/*************************************
 * 功能： 路边停车加密
 * 创建者： kim_tony
 * 创建日期：2017/1/17
 * 版权所有：深圳市亿车科技有限公司
 *************************************/

public class RoadParkEncrypUtil extends EncryUtilImpl {

    @Override
    public synchronized String urlParse(String url) {
        return super.urlParse(url);
    }

    @Override
    public synchronized String getEncryptionValuePair(String url, String signKey, String appKey, String imei, String trampTime, String sid) {
        return super.getEncryptionValuePair(url, signKey, appKey, imei, trampTime, sid);
    }

    @Override
    public synchronized String getEncryptionUrl(String url, String key) {
        return super.getEncryptionUrl(url, key);
    }
}
