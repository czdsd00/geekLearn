package com.lk.demo.netty;

import okhttp3.*;

import java.io.IOException;

public class OkhttpUtils {

    public static void get(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8082/geek/hello")
                .addHeader("geek","lk")
                .build();
        RequestBody body = request.body();
        try {
            Response execute = client.newCall(request).execute();
            System.out.println(execute.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    };
    public static void post(){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("name","geekLk")          // 添加表单项
                .addEncoded("charset","utf-8")      // 添加表单项，使用URI编码
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8082/geek/helloPost")
                .post(body).build();
        try {
            Response execute = client.newCall(request).execute();
            System.out.println(execute.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    };


    public static void main(String[] args)
    {
        post();
        get();
    }
}
