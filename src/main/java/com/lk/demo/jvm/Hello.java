package com.lk.demo.jvm;

public class Hello {


    public static void main(String[] args) {
        int a =1 ;
        int b =2 ;
        int c = a + b;
        int d = b - a;
        int e = 0;
        if(c >0){
           d = d *2;
           System.out.println(d);
        }
        for (int i = 0; i < 2; i++) {
            e = e +i;
        }
    }

    public static int add(int a ,int b){
        return  a+b;
    }
    public static void hello(){
        System.out.println("you are foolish");;
    }
}
