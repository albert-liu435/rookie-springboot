//package com.rookie.bigdata.common;
//
//import javax.servlet.ReadListener;
//import javax.servlet.ServletInputStream;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//
///**
// * @Classname MyServletInputStream
// * @Description
// * @Author rookie
// * @Date 2023/1/12 17:13
// * @Version 1.0
// */
//public class MyServletInputStream extends ServletInputStream {
//
//    private ByteArrayInputStream bis;
//
//    public MyServletInputStream(ByteArrayInputStream bis) {
//        this.bis = bis;
//    }
//
//    @Override
//    public boolean isFinished() {
//        return true;
//    }
//
//    @Override
//    public boolean isReady() {
//        return true;
//    }
//
//    @Override
//    public void setReadListener(ReadListener listener) {
//
//    }
//
//    @Override
//    public int read() throws IOException {
//        return bis.read();
//    }
//}
