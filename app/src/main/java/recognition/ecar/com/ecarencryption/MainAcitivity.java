package recognition.ecar.com.ecarencryption;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.ecar.factory.EncryptionUtilFactory;
import com.ecar.util.CastStringUtil;

import java.util.TreeMap;


/*************************************
 * 功能：
 * 创建者： kim_tony
 * 创建日期：2017/1/16
 * 版权所有：深圳市亿车科技有限公司
 *************************************/

public class MainAcitivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        printResult();
    }


    private void printResult() {
//         公用方法
        isEquels("binstrToStr",
                "510adc3949ba59abbe56e057f20f883a",
                (EncryptionUtilFactory.getDefault(true).createEpark().binstrToStr(
                        "110101 110001 110000 1100001 1100100 1100011 110011 111001 110100 111001 1100010 1100001 110101 111001 1100001 1100010 1100010 1100101 110101 110110 1100101 110000 110101 110111 1100110 110010 110000 1100110 111000 111000 110011 1100001"
                )));
        isEquels("getEncodedStr",
//                "1.1.3-NotMinify%E6%B5%8B%E8%AF%95",
                "vivo%20V3Max%20A",
                (EncryptionUtilFactory.getDefault(true).createEpark().getEncodedStr(
//                        "1.1.3-NotMinify测试"
                        "vivo V3Max A"
                )));
        isEquels("strToBinstr",
                "110100 110011 1100110 110110 1100100 110000 110100 1100110 110010 110000 110111 110000 1100100 1100010 110110 111000 1100100 110001 110010 110101 110100 111000 110110 110011 1100110 110011 111001 110001 111000 110110 110110 111001",
                (EncryptionUtilFactory.getDefault(true).createEpark().strToBinstr(
                        "43f6d04f2070db68d1254863f3918669"
                )));
        isEquels("binstrToChar",
                "4",
                ("" + EncryptionUtilFactory.getDefault(true).createEpark().binstrToChar(
                        "110100"
                )));
        isEquels("getAppendUrl",
                "http://192.168.0.115:7072//Index.aspx?versontype=1&t=member&method=invoiceapply&money=1000&phonenum=18923729010&title=%E5%8F%91%E7%A5%A8&parkuserid=16112518923729010",
                (EncryptionUtilFactory.getDefault(true).createEpark().getAppendUrl(
                        "http://192.168.0.115:7072//Index.aspx?versontype=1&t=member&method=invoiceapply",
                        "{money=1000, phonenum=18923729010, title=%E5%8F%91%E7%A5%A8}",
                        "16112518923729010"
                )));
        isEquels("getMD5Code",
                "8ea1f5cfde78541acb2970f5aabe9843",
                (EncryptionUtilFactory.getDefault(true).createEpark().getMD5Code(
                        "{abc:缺少参数}"
                )));

//        一体化
        isEquels("checkSign",
                "true",
                ("" + EncryptionUtilFactory.getDefault(true).createEpark().checkSign(
                        "1ba56e9614e143fed388bca2d70576e8",
                        "{\"message\":\"缺少参数\",\"ngis\":\"1ba56e9614e143fed388bca2d70576e8\",\"state\":2,\"ts\":1484818412833}",
                        "1000100 110011 110000 110010 111001 1000011 110111 110011 110100 110000 110110 110010 110010 110001 1000010 110000 110010 110000 110010 110110 1000010 110110 111000 110100 1000010 1000010 110000 110000 110101 110111 111001 1000011"
                )));
        isEquels("getSecurityKeys",
                "{ClientType=android&appId=904075102&cityname=&comid=200000002&latitude=4.9E-324&longitude=4.9E-324&method=addUseRecord&module=app&phonetype=SM705&service=Std&ts=1486606389319&u=20160510190532888742623268038887&v=20170113111620773151170099329112&ve=2&versin=1.1.4-%E5%BC%80%E5%8F%91&sign=146c0a4b64916874f584669656d87820",
                (EncryptionUtilFactory.getDefault(true).createEpark().getSecurityKeys(
                        "{ClientType=android, appId=904075102, cityname=, comid=200000002, latitude=4.9E-324, longitude=4.9E-324, method=addUseRecord, module=app, phonetype=SM705, service=Std, ts=1486606389319, u=20160510190532888742623268038887, v=20170113111620773151170099329112, ve=2, versin=1.1.4-开发}",
                        "111001 110000 110100 110000 110111 110101 110001 110000 110010",
                        "1000100 110011 110000 110010 111001 1000011 110111 110011 110100 110000 110110 110010 110010 110001 1000010 110000 110010 110000 110010 110110 1000010 110110 111000 110100 1000010 1000010 110000 110000 110101 110111 111001 1000011",
                        true,
                        true
                )));
        isEquels("getSecurityMapKeys",
                "{ClientType=android, appId=904075102, appcode=4, appname=roadapp, comid=200000002, method=checkForUpdate, module=app, service=Std, sign=afb9350413ed213e1fc64eb299cd8527, ve=2, versionCode=1.1.4-%E5%BC%80%E5%8F%91}",
                EncryptionUtilFactory.getDefault(true).createEpark().getSecurityMapKeys(
//                        "{ClientType=android, appId=904075102, appcode=4, appname=roadapp, comid=200000002, method=checkForUpdate, module=app, requestKey=D3029C73406221B02026B684BB00579C, service=Std, ve=2, versionCode=1.1.4-开发}",
//                        "{ClientType=android, applyduration=30, applytype=1, berthcode=B100002, channel=1, comid=200000018, method=prepaymentParkingPay, module=app, paytype=4, price=0.81, service=Std, t=7196546423623734915703, ts=1496397719654, u=20170504114006093960886040500491, vehicletype=2}",
//                        CastStringUtil.stringToTreeMap("{ClientType=android, berthcode=B10,0002, comid=200000018, method=prepaidParkTime, module=app, orderid=, parktime=30, service=Std, ts=1496401739985, u=20170504114006093960886040500491, v=20170602185905681582624078867184, vehicletype=1}"),
                        getMap(),
                        true,
                        true,
                        true,
                        "510832011",
                        "510adc3949ba59abbe56e057f20f883a"
                ));
//        路边
        isEquels("urlParse",
                "http://192.168.0.115:7072//otherapi/Index.aspx?versontype=1&method=getappversion&versioncode=14&versionname=1.2.1&ostype=android&phonemodel=SM705",
                (EncryptionUtilFactory.getDefault(true).createRoadPark().urlParse(
                        "http://192.168.0.115:7072//Index.aspx?versontype=1&t=other&method=getappversion&versioncode=14&versionname=1.2.1&ostype=android&phonemodel=SM705"
                )));

        isEquels("getEncryptionUrl",
                "http://192.168.0.115:7072//otherapi/Index.aspx?versontype=1&method=getappversion&versioncode=16&versionname=1.2.3&ostype=android&phonemodel=vivo%20V3Max%20A&appkey=101280918&security=5fcc6f9cde4e7bca2690488b59d15abf&mobilecode=861845039126103&timestamp=20170224131838&SID=&sign=09b1e4cf50a39db26d4d582d1c47f50d",

                EncryptionUtilFactory.getDefault(true).createRoadPark().getEncryptionUrl(
                        "http://192.168.0.115:7072//otherapi/Index.aspx?versontype=1&method=getappversion&versioncode=16&versionname=1.2.3&ostype=android&phonemodel=vivo%20V3Max%20A&appkey=101280918&security=5fcc6f9cde4e7bca2690488b59d15abf&mobilecode=861845039126103&timestamp=20170224131838&SID=",
                        "110100 110011 1100110 110110 1100100 110000 110100 1100110 110010 110000 110111 110000 1100100 1100010 110110 111000 1100100 110001 110010 110101 110100 111000 110110 110011 1100110 110011 111001 110001 111000 110110 110110 111001"
                )
        );

        isEquels("getEncryptionValuePair",
                "http://192.168.0.115:7072//otherapi/Index.aspx?versontype=1&method=getappversion&versioncode=16&versionname=1.2.3&ostype=android&phonemodel=vivo%20V3Max%20A&appkey=101280918&security=5fcc6f9cde4e7bca2690488b59d15abf&mobilecode=861845039126103&timestamp=20170224133236&SID=&sign=62ee63dfded13fd760b6c38e121735f5",
                EncryptionUtilFactory.getDefault(true).createRoadPark().getEncryptionValuePair(
                        "http://192.168.0.115:7072//otherapi/Index.aspx?versontype=1&method=getappversion&versioncode=16&versionname=1.2.3&ostype=android&phonemodel=vivo%20V3Max%20A",
                        "110100 110011 1100110 110110 1100100 110000 110100 1100110 110010 110000 110111 110000 1100100 1100010 110110 111000 1100100 110001 110010 110101 110100 111000 110110 110011 1100110 110011 111001 110001 111000 110110 110110 111001",
                        "110001 110000 110001 110010 111000 110000 111001 110001 111000",
                        "861845039126103",
                        "20170224133236",
                        "")
        );
        isEquels("getEncryptionValuePair",
                "http://192.168.0.115:7072//operationapi/Index.aspx?versontype=1&method=addcomplain&parkuserid=16112518923729010&comcontent=%E6%8A%95%E8%AF%89%E5%86%85%E5%AE%B9&appkey=101280918&security=309262c162fb0b81f7034b2db16fb2f6&mobilecode=864593021622278&timestamp=20170223233044&SID=sid79b2356e15133099f792bd8027c12637&sign=bd3b40c600f0de4fa463a62d9e8018b9",
                EncryptionUtilFactory.getDefault(true).createRoadPark().getEncryptionValuePair(
                        "http://192.168.0.115:7072//operationapi/Index.aspx?versontype=1&method=addcomplain&parkuserid=16112518923729010&comcontent=%E6%8A%95%E8%AF%89%E5%86%85%E5%AE%B9",
                        "110100 110011 1100110 110110 1100100 110000 110100 1100110 110010 110000 110111 110000 1100100 1100010 110110 111000 1100100 110001 110010 110101 110100 111000 110110 110011 1100110 110011 111001 110001 111000 110110 110110 111001",
                        "110001 110000 110001 110010 111000 110000 111001 110001 111000",
                        "864593021622278",
                        "20170223233044",
                        "sid79b2356e15133099f792bd8027c12637")
        );

//        宜停车
        isEquels(
                "getEncryptionValuePair_YiTingChe",
                "http://183.62.162.254:8899/memberapi/Index.aspx?versontype=1&method=login&appversion=2.6.1-debug&mobileno=18923729010&ostype=android_5.1.1&phonetype=vivo%20V3Max%20A&pwd=037760af399974fb5d0125b49a56cbbc&parkuserid=&appkey=101280918&security=0d7c4e48454c3f94e310686fe6772dee&mobilecode=861845039126103&timestamp=20170223235040&SID=&sign=2bc61e64b58c933b40dcf0239ddf1728",
                EncryptionUtilFactory.getDefault(true).creatParkFee().getEncryptionValuePair_YiTingChe(
                        "http://183.62.162.254:8899/memberapi/Index.aspx?versontype=1&method=login&appversion=2.6.1-debug&mobileno=18923729010&ostype=android_5.1.1&phonetype=vivo%20V3Max%20A&pwd=037760af399974fb5d0125b49a56cbbc&parkuserid=",
                        "110100 110011 1100110 110110 1100100 110000 110100 1100110 110010 110000 110111 110000 1100100 1100010 110110 111000 1100100 110001 110010 110101 110100 111000 110110 110011 1100110 110011 111001 110001 111000 110110 110110 111001",
                        "110001 110000 110001 110010 111000 110000 111001 110001 111000",
                        "861845039126103",
                        "20170223235040",
                        ""
                )
        );
//        isEquels(
//                "getEncryptionValuePair_YiTingChe",
//                "http://183.62.162.254:8899/operationapi/Index.aspx?versontype=1&method=addcomplain&parkuserid=15041418923729010&comcontent=%E6%8A%95%E8%AF%89%E5%86%85%E5%AE%B9&appkey=101280918&security=309262c162fb0b81f7034b2db16fb2f6&mobilecode=861845039126103&timestamp=20170223235745&SID=sidedc8e23dc073c5756ac7f9e76d6e1ee4&sign=4d6ea06e8ea5041f805590920e11f822",
//                EncryptionUtilFactory.getDefault(true).creatParkFee().getEncryptionValuePair_YiTingChe(
//                        "http://183.62.162.254:8899/operationapi/Index.aspx?versontype=1&method=addcomplain&parkuserid=15041418923729010&comcontent=%E6%8A%95%E8%AF%89%E5%86%85%E5%AE%B9",
//                        "110100 110011 1100110 110110 1100100 110000 110100 1100110 110010 110000 110111 110000 1100100 1100010 110110 111000 1100100 110001 110010 110101 110100 111000 110110 110011 1100110 110011 111001 110001 111000 110110 110110 111001",
//                        "110001 110000 110001 110010 111000 110000 111001 110001 111000",
//                        "861845039126103",
//                        "20170223235745",
//                        "sidedc8e23dc073c5756ac7f9e76d6e1ee4"
//                )
//        );

//        路边PDA
        isEquels("sign",
//                "http://183.62.162.254:8899/OperationAPI/Index.aspx?method=equipinfo&sign=c131fea6fe173474e30b26ed7e073a49",
//                EncryptionUtilFactory.getDefault(true).createRoadPda().sign(
//                        "http://183.62.162.254:8899/OperationAPI/Index.aspx?method=equipinfo",
//                        "[Appkey=606300949, Security=5b82066ec0544ecc66d5ed62a7bce3de, adduserid=746, equiptype=1, faultcode=03, ordercontent=下半年你先休息, MD50=961524aa7d3a17bcf869227afa8604a2]",
//                        "e40a1c78080249df994eaedb833d0434"
//                )
                "http://183.62.162.254:8899/OperationAPI/Index.aspx?method=pdacorrection&sign=7dbb183021f5d2e31b3ea823c3fab4e3",
                EncryptionUtilFactory.getDefault(true).createRoadPda().sign(
                        "http://183.62.162.254:8899/OperationAPI/Index.aspx?method=pdacorrection",
                        "[Appkey=606300949, Security=3c016261e68ea3760ffdcf5693f3fdea, berthcode=219202, parkstatus=0, token=355066066194848, userId=59, username=020108, MD50=0447431223af5457673881260ca7bbff, MD51=4771b54f089fa83400091ec263ab004b]",
                        "e40a1c78080249df994eaedb833d0434"
                )
        );

        String str = "{ClientType=android, appId=510832011, berthcode=B10,0002, comid=200000018, method=prepaid，ParkTime, module=app, nickname=&@;<&&#%&#%，，，$2+, sign=62eddc9dc2480f0e43dcf5e7d652ab7a, ve=2}";
        Log.d("tagutil", "printResult: " + CastStringUtil.stringToTreeMap(str));
    }

    private void isEquels(String method, String str1, String str2) {
        Log.d("tagutil", method + "标准值=" + str1);
        Log.d("tagutil", method + "加密后=" + str2);

        if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
            Log.d("tagutil", method + "  result: " + str1.trim().equals(str2.trim()));
        } else {
            Log.d("tagutil", method + "  result: " + false);
        }
    }

    public TreeMap<String, String> getMap() {
//        "{ClientType=android, berthcode=B10,0002, comid=200000018, method=prepaidParkTime, module=app, orderid=, parktime=30, service=Std, ts=1496401739985, u=20170504114006093960886040500491, v=20170602185905681582624078867184, vehicletype=1}"),

        TreeMap treeMap = new TreeMap();
        treeMap.put("ClientType", "android");
        treeMap.put("berthcode", "B10,0002");
        treeMap.put("comid", "200000018");
        treeMap.put("method", "prepaid，ParkTime");
        treeMap.put("module", "app");
        treeMap.put("nickname", "&@;<&$：；；+￥");


        return treeMap;
    }
}

