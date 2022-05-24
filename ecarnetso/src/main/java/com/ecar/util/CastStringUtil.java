package com.ecar.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*************************************
 * 功能：
 * 创建者： kim_tony
 * 创建日期：2017/1/20
 * 版权所有：深圳市亿车科技有限公司
 *************************************/

public class CastStringUtil {

    final public static String DOT_SIGN = "&#%"; //特殊字符

    /**
     * 函数名称: parseData    fds
     * 函数描述: 将json字符串转换为map
     *
     * @param data
     * @return
     */
    public static TreeMap<String, String> jsonToMap(String data) {
        GsonBuilder gb = new GsonBuilder();
        Gson g = gb.create();
        TreeMap<String, String> map = g.fromJson(data, new TypeToken<TreeMap<String, String>>() {
        }.getType());
        return map;
    }

    public static TreeMap<String, String> stringToTreeMap(String singInfo) {

        String str1 = singInfo.
                replaceAll("^\\{|\\}$", "").
//                replaceAll("\\{|\\}", "").
                replaceAll(" ", "");//singInfo是一个map  toString后的字符串。
//        String str2 = str1.replaceAll(" ", "");
//        String str3 = str2.replaceAll(DOT_SIGN, "&"); //


        TreeMap<String, String> map = new TreeMap<>();
        if (!TextUtils.isEmpty(str1)) {
            String[] resArray = str1.split(",");
            if (0 != resArray.length) {
                for (String arrayStr : resArray) {
                    if (!TextUtils.isEmpty(arrayStr)) {
                        arrayStr = arrayStr.replaceAll(DOT_SIGN, ",");
                        int index = arrayStr.indexOf("=");
                        if (-1 != index) {
                            map.put(arrayStr.substring(0, index), arrayStr.substring(index + 1));
                        }
                    }
                }
            }
        }

        return map;
    }

    public static TreeMap<String, String> mEraseDel(TreeMap<String, String> treeMap) {
        if (treeMap == null) {
            return new TreeMap<>();
        }
        //判断参数是否有逗号
        String treeMapStr = treeMap.toString();
        if (!treeMapStr.contains("+") &&
                treeMapStr.split(",").length == (treeMapStr.split("=").length - 1)) {    //参数有逗号
            return treeMap;
        }

        //用特殊字符替换英文逗号
        try {
            for (String in : treeMap.keySet()) {
                // map.keySet()返回的是所有key的值
                String str = treeMap.get(in);// 得到每个key多对用value的值
                if (str.contains(",")) {
                    str = str.replaceAll(",", DOT_SIGN);
                }
                if (str.contains("+")) {  //过滤掉+
                    str = str.replace("+", "");
                }
                treeMap.put(in, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return treeMap;
        }

        return treeMap;
    }

}
