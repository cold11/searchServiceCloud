package com.cold.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by ohj on 2016/9/1.
 */
public class Base64Utils {

    public static String encode(String text){
        String result = "";
        if(text!=null){
            try {
                result = Base64.encode(text.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String decode(String text){
        String result = "";
        if(text!=null){
            try {
                result = new String(Base64.decode(text),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static void main(String[] args) {
        //char c = 0xb;
        System.out.println(encode(""));
        System.out.println(new String(Base64.decode("YWJzdHJhY3Qg")));
    }
}
