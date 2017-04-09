/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productchiper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isham
 */
public class IOManager {
    public static String Write(String Message,String path){
        try(FileWriter fw = new FileWriter(path);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(Message); 
                return "SUCCEEDED!";
            } catch (IOException e) {
                return "FAILED!";
                
            }
    }
    
    public static String Read(String fileName){
        String readings="";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
        while ((line = br.readLine()) != null) {
            readings+=line;
        }
        } catch (IOException ex) {
            return "FAILED";
        }
        return readings;
    }
    
    
}
