package com.example.demo.Service;


import org.springframework.stereotype.Service;

import java.security.MessageDigest;

//MD5加密
@Service
public class EhconedByMD5Service {

    public String MD5(String s){

        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] bytes=s.getBytes();
            MessageDigest md=MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte[] bytes1=md.digest();
            int l=bytes1.length;
            char []chars=new char[l*2];
            int k = 0;
            for (int i = 0; i < l; i++) {
                byte byte0 = bytes1[i];
                chars[k++] = hexDigits[byte0 >>> 4 & 0xf];
                chars[k++] = hexDigits[byte0 & 0xf];
            }
            System.out.println("1次加密后的密码"+chars);
            return new String(chars);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /*
 * md5算法100次加密
 */
    public String hundredMd5(String str){
        for(int i=0; i<100;i++){
            str=this.MD5(str);
        }
        System.out.println(str);
        return str;
    }
}
