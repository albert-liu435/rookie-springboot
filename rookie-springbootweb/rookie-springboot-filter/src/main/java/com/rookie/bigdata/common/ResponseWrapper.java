//package com.rookie.bigdata.common;
//
//import jakarta.servlet.ReadListener;
//import jakarta.servlet.ServletInputStream;
//import jakarta.servlet.ServletOutputStream;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpServletResponseWrapper;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//
//import java.io.*;
//
///**
// * @Class ResponseWrapper
// * @Description
// * @Author rookie
// * @Date 2024/7/24 13:37
// * @Version 1.0
// */
//public class ResponseWrapper extends HttpServletResponseWrapper {
//
//
//    //参数字节数组
//    private byte[] responseBody;
//
//    //Http请求对象
//    private HttpServletResponse response;
//
//
//    /**
//     * Constructs a response adaptor wrapping the given response.
//     *
//     * @param response The response to be wrapped
//     * @throws IllegalArgumentException if the response is null
//     */
//    public ResponseWrapper(HttpServletResponse response) {
//        super(response);
//        this.response=response;
//    }
//
//
//    @Override
//    public ServletOutputStream getOutputStream() throws IOException {
//        /**
//         * 每次调用此方法时将数据流中的数据读取出来，然后再回填到InputStream之中
//         * 解决通过@RequestBody和@RequestParam（POST方式）读取一次后控制器拿不到参数问题
//         */
//        if (null == this.responseBody) {
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            IOUtils.copy(response.getOutputStream(), baos);
//            this.requestBody = baos.toByteArray();
//        }
//
//        final ByteArrayOutputStream bais = new ByteArrayOutputStream(requestBody);
//        return new ServletInputStream() {
//
//            @Override
//            public boolean isFinished() {
//                return false;
//            }
//
//            @Override
//            public boolean isReady() {
//                return false;
//            }
//
//            @Override
//            public void setReadListener(ReadListener listener) {
//
//            }
//
//            @Override
//            public int read() {
//                return bais.read();
//            }
//        };
//    }
//
//    @Override
//    public ServletInputStream getInputStream() throws IOException {
//        /**
//         * 每次调用此方法时将数据流中的数据读取出来，然后再回填到InputStream之中
//         * 解决通过@RequestBody和@RequestParam（POST方式）读取一次后控制器拿不到参数问题
//         */
//        if (null == this.requestBody) {
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            IOUtils.copy(request.getInputStream(), baos);
//            this.requestBody = baos.toByteArray();
//        }
//
//        final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody);
//        return new ServletInputStream() {
//
//            @Override
//            public boolean isFinished() {
//                return false;
//            }
//
//            @Override
//            public boolean isReady() {
//                return false;
//            }
//
//            @Override
//            public void setReadListener(ReadListener listener) {
//
//            }
//
//            @Override
//            public int read() {
//                return bais.read();
//            }
//        };
//    }
//
//    @Override
//    public BufferedWriter getWriter() throws IOException {
//        return new BufferedWriter(new OutputStreamWriter(this.getOutputStream()));
//    }
//}
