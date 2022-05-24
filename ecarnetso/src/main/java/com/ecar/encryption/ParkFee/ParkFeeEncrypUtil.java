package com.ecar.encryption.ParkFee;

import com.ecar.encryption.base.EncryUtilImpl;

/*************************************
 * 功能：
 * 创建者： kim_tony
 * 创建日期：2017/1/17
 * 版权所有：深圳市亿车科技有限公司
 *************************************/

public class ParkFeeEncrypUtil extends EncryUtilImpl {
    @Override
    public synchronized String getEncryptionValuePair_YiTingChe(String url, String signKey, String appKey, String imei, String trampTime, String sid) {
        return super.getEncryptionValuePair_YiTingChe(url, signKey, appKey, imei, trampTime, sid);
    }
}