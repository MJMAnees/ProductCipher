/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productchiper;

import java.util.Collections;

/**
 *
 * @author Isham
 */
public class Processor_16 {
    private  static final int[][] shuffleTable={
        {0,11,22,33},
        {1,12,23,30},
        {2,13,20,31},
        {3,10,21,32}};
    
    private static final int[][] reorderTable={
        {0,10,20,30},
        {31,1,11,21},
        {22,32,2,12},
        {13,23,33,3}};
    
    
    public static String encrypt(String planeText16){
        int[][] planeVals = {AsciiTranslator.textToAscii(planeText16.substring(0,4)),AsciiTranslator.textToAscii(planeText16.substring(4,8)),AsciiTranslator.textToAscii(planeText16.substring(8,12)),AsciiTranslator.textToAscii(planeText16.substring(12,16))};
        int[][] subVals=new int[4][4];
        int[][] shuffledVals= new int[4][4];
        for(int i=0;i<4;i++){
            subVals[i]=SBox.GetSBoxValue(planeVals[i]);
        }
        for(int j=0;j<4;j++){
            for(int k=0;k<4;k++){
                int shuffledVal=shuffle(j*10+k);
                int row=shuffledVal/10;
                int col=shuffledVal%10;
                shuffledVals[j][k]=subVals[row][col];
            }
        }
        return AsciiTranslator.asciiToText(shuffledVals[0])+AsciiTranslator.asciiToText(shuffledVals[1])+AsciiTranslator.asciiToText(shuffledVals[2])+AsciiTranslator.asciiToText(shuffledVals[3]);
    }
    public static String decrypt(String shuffledText16){
        int[][] shuffledVals = {AsciiTranslator.textToAscii(shuffledText16.substring(0,4)),AsciiTranslator.textToAscii(shuffledText16.substring(4,8)),AsciiTranslator.textToAscii(shuffledText16.substring(8,12)),AsciiTranslator.textToAscii(shuffledText16.substring(12,16))};
        int[][] subVals=new int[4][4];
        int[][] planeVals= new int[4][4];
        for(int j=0;j<4;j++){
            for(int k=0;k<4;k++){
                int orderedVal=reorder(j*10+k);
                int row=orderedVal/10;
                int col=orderedVal%10;
                subVals[j][k]=shuffledVals[row][col];
            }
        }
        for(int i=0;i<4;i++){
            planeVals[i]=SBox.GetInvSBoxValue(subVals[i]);
        }
        
        return AsciiTranslator.asciiToText(planeVals[0])+AsciiTranslator.asciiToText(planeVals[1])+AsciiTranslator.asciiToText(planeVals[2])+AsciiTranslator.asciiToText(planeVals[3]);
    
    }
    private static int shuffle(int x){
        int row=x/10;
        int col=x%10;
        return shuffleTable[row][col];
    }
    private static int reorder(int x){
        int row=x/10;
        int col=x%10;
        return reorderTable[row][col];
    }
    
}
