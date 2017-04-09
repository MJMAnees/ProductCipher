/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productchiper;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Isham
 */
public class TextBinaryConvertor {
    public static String getBinary(String s){
       String result="";
       for (int i=0;i<s.length();i++){
           String binary=convertToBinary(s.charAt(i));
           result+=binary;
       }
       return result;
    }
    private static String convertToBinary(int x){
        String bits =Integer.toBinaryString(x);
        int length = 8-bits.length();
        String prefix="";
        for (int i=0; i<length;++i){
            prefix=prefix+"0";
        }
        return prefix+bits;
    }
    public static String getText(String binary){
        String text="";
        for (int i=0;i<binary.length();i+=8) {
            text+=(char)Integer.parseInt(binary.substring(i,i+8), 2);
        }
        return text;
    }
    
}
