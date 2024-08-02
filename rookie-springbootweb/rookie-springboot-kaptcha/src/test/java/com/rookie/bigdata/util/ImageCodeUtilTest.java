package com.rookie.bigdata.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class ImageCodeUtilTest
 * @Description
 * @Author rookie
 * @Date 2024/8/2 17:29
 * @Version 1.0
 */
class ImageCodeUtilTest {

    @Test
    void test01() {
        //String code = "13800000000";
        String code = "1667320863285510145";
        //String code = "abcdefg123456789012";
        //String code = "http://www.baidu.com";
        String title = "商品名称(超出不显示)";
        System.out.println(ImageCodeUtil.toFile(ImageCodeUtil.BarCode.createWithWords(code, title, ImageCodeUtil.Size.SMALL)));
        System.out.println(ImageCodeUtil.toFile(ImageCodeUtil.BarCode.createWithWords(code, title, ImageCodeUtil.Size.MIDDLE)));
        System.out.println(ImageCodeUtil.toFile(ImageCodeUtil.BarCode.createWithWords(code, title, ImageCodeUtil.Size.BIG)));

        //System.out.println(toFile(QrCode.create(code, 500)));
        //System.out.println(ImageCodeUtil.toFile(ImageCodeUtil.QrCode.create(code, ImageCodeUtil.Size.SMALL)));
        //System.out.println(ImageCodeUtil.toFile(ImageCodeUtil.QrCode.create(code, ImageCodeUtil.Size.MIDDLE)));
        //System.out.println(ImageCodeUtil.toFile(ImageCodeUtil.QrCode.create(code, ImageCodeUtil.Size.BIG)));
    }

    @Test
    void test02() {
        // 扫描
        // 13800000000
        //String[] fs = {"168636218096.png", "168636218180.png", "168636218127.png"};

        // 1667320863285510145
        //String[] fs = {"168636260651.png", "168636260766.png", "168636260794.png"};

        // abcdefg123456789012
        //String[] fs = {"168636320566.png", "168636320750.png", "168636320743.png"};

        // http://www.baidu.com
        String[] fs = {"172259115028.png", "172259118241.png", "172259119275.png"};

        for (String f : fs) {
            System.out.println("-----------------");
            System.out.println(ImageCodeUtil.scan(f));
        }
    }

}
