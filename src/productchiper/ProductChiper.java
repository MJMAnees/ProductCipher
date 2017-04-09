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
public class ProductChiper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(AsciiTranslator.textToAscii("isham"));
        for (int arg : AsciiTranslator.textToAscii("isham")) {
            System.out.println(arg);
        }
        System.out.println(AsciiTranslator.asciiToText(AsciiTranslator.textToAscii("isham")));
    }
    
}
