/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productchiper;

import com.sun.corba.se.impl.util.PackagePrefixChecker;

/**
 *
 * @author Isham
 */
public class EncryptionEngine {
    public static String encrypt(String planeText){
        String currentText=planeText;
            String key=KeyGenerator.generateKey(3);
            String suffledText= Processor_16.encrypt(currentText);
            String byteText=TextBinaryConvertor.getBinary(suffledText);
            currentText=TextBinaryConvertor.getText(XOR(byteText, key));
          
       return currentText;
    }
    public static String decrypt(String cipherText){
       String key=KeyGenerator.generateKey(3);
       String binary=TextBinaryConvertor.getBinary(cipherText);
       String byteText=XOR(binary, key);
       String SuffleText=TextBinaryConvertor.getText(byteText);
       return Processor_16.decrypt(SuffleText);
       
    }
    private static String XOR(String x, String y){
        String[] lx = x.split("");
        String[] ly = y.split("");
        String result="";
        for (int i=0;i<lx.length;i++){
            result+= ((lx[i]).equalsIgnoreCase(ly[i])) ? "0" : "1";
        }
        return result; 
    }
}
