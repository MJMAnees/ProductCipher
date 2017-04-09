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
public class AsciiTranslator {
    public static int[] textToAscii(String planeText){
        //takes a text and converts to int[]
        int length=planeText.length();
        int[] vals=new int[length];
        for(int i=0;i<length;i++){
            vals[i]=(int) planeText.charAt(i); 
         }
        return vals;
    }
    public static String asciiToText(int[] vals){
        //take an int[] converts to text
        String text="";
        for (int val : vals) {
            text+=(char)val;
        }
        return text;
    }
    
}
