package com.rookie.bigdata.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname SignUtil
 * @Description TODO
 * @Author rookie
 * @Date 2021/8/19 17:25
 * @Version 1.0
 */
public class SignUtil {



    public static TreeMap<String, String> createHeaderMap(/*String contentType, */String appKey, String integrationId, String timestamp,String token) {
        TreeMap<String, String> headerMap = new TreeMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("app_key", appKey);
        headerMap.put("timestamp", timestamp);
        headerMap.put("integration_id", integrationId);
        String sign = creatSign(headerMap, token);
         headerMap.put("sign", sign);
        return headerMap;
    }

    /**
     * 接口sign生成
     *
     * @return
     * @paramheaderMap，token:应用系统秘钥
     */
    public static String creatSign(TreeMap<String, String> headerMap, String token) /*throws Exception*/ {
        String mySign = "";
        if (headerMap != null && !headerMap.isEmpty()) {
            //1、headerMap中除去sign
            if (headerMap.keySet().contains("sign")) {
                //除去sign
                headerMap.remove("sign");
            }
            //2、headerMap参数按照ASCII顺序排序
            String[] keyset = headerMap.keySet().toArray(new String[0]);
            Arrays.sort(keyset);//排序
            //3、sign拼接（headerMap参数）
            StringBuilder sbSign = new StringBuilder();
            sbSign.append(token);//集成系统秘钥（token）
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                if (entry.getValue() != null && entry.getValue().length() > 0) {
                    sbSign.append(entry.getKey()).append(entry.getValue());
                }
            }
            sbSign.append(token);//集成系统秘钥（token）
            //4、md5加密sign
            try {
                mySign = md5(sbSign.toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return mySign;
    }

    public static String md5(byte[] sbSign) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(sbSign);
            byte[] hash = md.digest();
            StringBuffer outStrBuf = new StringBuffer(32);
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i] & 0xFF;
                if (v < 16) {
                    outStrBuf.append('0');
                }
                outStrBuf.append(Integer.toString(v, 16).toLowerCase());
            }
            return outStrBuf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return new String(sbSign);
        }
    }
}
