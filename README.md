使用方法
======================================


1.一体化类(其他项目类结构类似)
------------------------------------------
一体化<br>
```
@Override
public String getSecurityKeys( String tMap,
                         String appid,
                         String requestKey,
                         boolean isEncode,
                         boolean isCheck) {
 return super.getSecurityKeys(tMap, appid, requestKey, isEncode,isCheck);
 }
 @Override
 public String getSecurityMapKeys(String tMap, boolean encode, boolean isSign, String appid, String requestKey) {
  return super.getSecurityMapKeys(tMap, encode, isSign, appid, requestKey);
  }

    @Override
    public boolean checkSign(String sign, String content, String requestKey) {
        return super.checkSign(sign, content, requestKey);
    }
```
<br>
2.调用加密方法
------------------------------------------
```
例：一体化checkSign方法
EncryptionUtilFactory.getDefault(true).createEpark().checkSign(...);
```
