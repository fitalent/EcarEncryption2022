package com.ecar.encryption.Epark;

import com.ecar.encryption.base.EncryUtilImpl;
import com.ecar.util.CastStringUtil;

import java.util.Map;
import java.util.TreeMap;

/*************************************
 * 功能： 一体化加密
 * 创建者： kim_tony
 * 创建日期：2017/1/17
 * 版权所有：深圳市亿车科技有限公司
 *************************************/

public class EparkEncrypUtil extends EncryUtilImpl {


    @Override
    public String getSecurityKeys(String tMap,
                                  String appid,
                                  String requestKey,
                                  boolean isEncode,
                                  boolean isCheck) {
        return super.getSecurityKeys(tMap, appid, requestKey, isEncode, isCheck);
    }


    @Override
    public String getSecurityMapKeys(TreeMap<String, String> tMap, boolean encode, boolean isSign, boolean isNeedVe, String appid, String requestKey) {
        return super.getSecurityMapKeys(tMap, encode, isSign, isNeedVe, appid, requestKey);
    }


    @Override
    public boolean checkSign(String sign, String content, String requestKey) {
        return super.checkSign(sign, content, requestKey);
    }


}
