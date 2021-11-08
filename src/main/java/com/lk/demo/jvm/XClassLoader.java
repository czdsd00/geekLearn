package com.lk.demo.jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class XClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {
        String className = "Hello";
        String methodName = "hello";
        XClassLoader xClassLoader = new XClassLoader();
        Class<?> aClass = xClassLoader.findClass(className);
        Method method = aClass.getMethod(methodName);
        //创建对象实例
        Object instance = aClass.getDeclaredConstructor().newInstance();
        method.invoke(instance);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String resourcePath = name.replace(".", "/");

        String suffix = ".xlass";

        resourcePath = resourcePath + suffix;
        Class helloClass = null;
        byte[] aByte = getByteX(resourcePath);
//            byte[] decode = decode(aByte);
        helloClass = defineClass(name,aByte,0, aByte.length);


        return helloClass;
    }

    public static byte[] decode(byte[] bytes){
        byte[] byteArray = new byte[bytes.length];

        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = (byte) (255-bytes[i]);
        }

        return byteArray;

    }

    public static byte[] getByte(String path) throws IOException {

        File f = new File(path);
        if (!f.exists()) {
            throw new FileNotFoundException(path);
        }

        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public byte[] getByteX(String source){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(source);
        try {
            int available = inputStream.available();
            byte[] bytes = new byte[available];
            inputStream.read(bytes);
            byte[] decode = decode(bytes);
            return decode;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return new byte[1];

    }
}
