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
    public static void setKey(String key){
        KeyGenerator.currentKey=key;
    }
    public static String getKey(){
        return KeyGenerator.currentKey;
    }
    
    
}
