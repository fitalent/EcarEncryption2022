package com.ecar.encryption.base;


import com.ecar.encryption.EncryUtil;
import com.ecar.util.CastStringUtil;
import com.ecar.util.TagUtil;

import java.util.TreeMap;

import static com.ecar.util.TagUtil.printResult;

public class EncryUtilImpl extends EncryUtil {
    //公共方法 ***************************************************
    public synchronized String getMD5Code(String str) {
        String result = mGetMD5Code(str);
        return getResult(result);
    }

    public synchronized String binstrToChar(String str) {
        String result = String.valueOf(mBinstrToChar(str));
        return getResult(result);
    }

    public synchronized String binstrToStr(String str) {
        String result = mBinstrToStr(str);
        return getResult(result);
    }

    public synchronized String strToBinstr(String str) {
        String result = mStrToBinstr(str);
        return getResult(result);
    }

    public synchronized String getAppendUrl(String baseUrl, String treeMap, String parkUrl) {
        String result = mGetAppendUrl(baseUrl, treeMap, parkUrl);
        return getResult(result);
    }

    public synchronized String getEncodedStr(String str) {
        String result = mGetEncodedStr(str);
        return getResult(result);
    }

    //返回结果
    private synchronized String getResult(String result) {
        printResult(result);
        return result == null ? "" : result;
    }

    //一体化 ***************************************************

    protected synchronized String getSecurityMapKeys(
            TreeMap<String, String> tMap,
            boolean encode,
            boolean isSign,
            boolean isNeedVe,
            String appid,
            String requestKey) {

        String result = mGetSecurityMapKeys(
                CastStringUtil.mEraseDel(tMap).toString(),
                encode,
                isSign,
                isNeedVe,
                appid,
                requestKey
        );  //逗号恢复

        return getResult(result);
    }


    protected synchronized boolean checkSign(
            String sign,
            String content,
            String requestKey) {

        boolean result = mCheckSign(
                sign,
                content,
                requestKey
        );

        return result;
    }

    protected String getSecurityKeys(
            String tMap,
            String appid,
            String requestKey,
            boolean isEncode,
            boolean isCheck
    ) {

        String result = mGetSecurityKeys(
                tMap,
                appid,
                requestKey,
                isEncode,
                isCheck
        );

        return getResult(result);
    }

    //路边停车 ***************************************************
    protected  synchronized String getEncryptionValuePair(String url,
                                            String signKey,
                                            String appKey,
                                            String imei,
                                            String trampTime,
                                            String sid) {

        String result = mGetEncryptionValuePair_YTC(url,
                signKey,
                appKey,
                imei,
                trampTime,
                sid);

        return getResult(result);
    }

    protected synchronized String urlParse(String url) {
        return mUrlParse(url);
    }

    protected synchronized String getEncryptionUrl(String url,
                                      String key) {
        String result = mGetEncryptionUrl(
                url,
                key);
        return getResult(result);

    }

    //宜停车***************************************************
    protected synchronized String getEncryptionValuePair_YiTingChe(String url,
                                                      String signKey,
                                                      String appKey,
                                                      String imei,
                                                      String trampTime,
                                                      String sid) {
        String result = mGetEncryptionValuePair(
                url,
                signKey,
                appKey,
                imei,
                trampTime,
                sid);
        return getResult(result);

    }

    //pda ***************************************************
    protected synchronized String  sign(String url,
                          String signParam,
                          String requestKey) {
        String result = mSign(
                url,
                signParam,
                requestKey);

        TagUtil.printResult(result);
        return result == null ? "" : result;
    }


}
