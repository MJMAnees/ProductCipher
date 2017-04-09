/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productchiper;

/**
 *
 * @author Isham
 */
public class KeyGenerator {
    private static String currentKey;
    private static String byteKey;
    public static void setKey(String key){
        KeyGenerator.currentKey=key;
        setByteKey();
    }
    public static String getKey(){
        return KeyGenerator.currentKey;
    }
    public static String generateKey(int roundNumber){
        System.out.println(currentKey);
        return shift(byteKey.substring(0,64),roundNumber)+shift(byteKey.substring(64,128),roundNumber);
        
    }
    private static String shift(String bytes,int times){
        if(times==0) {return bytes;}
        return shift(bytes.substring(1,bytes.length())+bytes.substring(0,1),times-1);
    }
    private static String get128Bits(String text){
        String s = setSize(text);
        return TextBinaryConvertor.getBinary(s);
    }
    
    private static String setSize(String s){
        if(s.length()==16) return s;
        if(s.length()>16) return s.substring(0,16);
        else return setSize(s+s);
    }

    private static void setByteKey() {
        byteKey=get128Bits(currentKey);
    }
}
