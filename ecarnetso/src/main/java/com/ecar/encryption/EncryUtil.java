package com.ecar.encryption;


public class EncryUtil {
    static {
        System.loadLibrary("ENCRYP");
    }

    //public
    public static native String mGetMD5Code(String str);

    public static native String mBinstrToChar(String str);

    public static native String mBinstrToStr(String str);

    public static native String mStrToBinstr(String str);

    public static native String mGetAppendUrl(String baseUrl,String treeMap,String parkUserUrl);

    public static native String mGetEncodedStr(String str);


    //yitihua
    protected static native String mGetSecurityMapKeys(String tMap,
                                                       boolean encode,
                                                       boolean isSign,
                                                       boolean isNeedVe,
                                                       String appid,
                                                       String requestKey);

    protected static native boolean mCheckSign(String sign,
                                              String content,
                                              String requestKey);

    protected static native String mGetSecurityKeys(String tMap,
                                                    String appid,
                                                    String requestKey,
                                                    boolean encode,
                                                    boolean isSign
    );


    //roadparking
    protected static native String mUrlParse(String url);

    protected static native String mGetEncryptionValuePair(String url,
                                                           String signKey,
                                                           String appKey,
                                                           String imei,
                                                           String trampTime,
                                                           String sid);

    protected static native String mGetEncryptionUrl(String url,
                                                     String key);

    //yitingche
    protected static native String mGetEncryptionValuePair_YTC(String url,
                                                               String signKey,
                                                               String appKey,
                                                               String imei,
                                                               String trampTime,
                                                               String sid);


    //pda
    protected static native String mSign(String url,
                                         String signParam,
                                         String requestKey);

}
