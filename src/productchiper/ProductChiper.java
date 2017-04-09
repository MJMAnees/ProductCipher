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

   
    public static void doEncrypt(String filePath,String Writingpath,String key){
        KeyGenerator.setKey(key+"qwertyuiopasdfgh");
        String input=IOManager.Read(filePath);
        input+="                ";
        String out="";
        int length=input.length()-input.length()%16;
        for(int i=0;i<length;i+=16){
           out+= EncryptionEngine.encrypt(input.substring(i,i+16));
           
        }
        IOManager.Write(out,Writingpath+"\\EncryptedData.txt");
        
    }
    public static void doDecrypt(String filePath,String Writingpath,String key){
        KeyGenerator.setKey(key+"qwertyuiopasdfgh");
        String data=IOManager.Read(filePath);
        int length=data.length()-data.length()%16;
        String out="";
        for(int i=0;i<length;i+=16){
           out+= EncryptionEngine.decrypt(data.substring(i,i+16));
           
        }
        IOManager.Write(out,Writingpath+"\\DecryptedData.txt");
        
    }
     
    
    
    
}
