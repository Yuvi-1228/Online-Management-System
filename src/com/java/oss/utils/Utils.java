/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.oss.utils;

import com.java.oss.classes.OrderItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ajay
 */
public class Utils {
    
    public static final String P_FILENAME = "products.txt";
    public static String U_FILENAME = "users.txt";
    
    public static List<OrderItem> cartItems = new ArrayList<>();

    
    public static int generateId(String filename) throws IOException {
        File file = new File(filename);
        
        if(!file.exists()) {
            return 1;
        }
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        String lastLine = "";
        String currentLine = "";
        
        while((currentLine = reader.readLine()) != null) {
            lastLine = currentLine;
        }
        
        if(lastLine.isEmpty()) {
            return 1;
        }else{
            int id = Integer.parseInt(lastLine.split(",")[0]) ;
            return id + 1;
        }
    }
    
        
    public static boolean updateFile(String filename, int id, List<String> newRecord) {
        try {
            File oldFile = new File(filename);
            FileReader fr = new FileReader(oldFile);
            BufferedReader br = new BufferedReader(fr);
            
            File tempFile = new File("temp.csv");
            if(!tempFile.exists()) {
                tempFile.createNewFile();
            }
            
            FileWriter fw = new FileWriter(tempFile);
            PrintWriter pw = new PrintWriter(fw);
            
            String line = br.readLine();
            
            while(line != null) {
                
                List<String> records = Arrays.asList(line.split(","));
                
                if(Integer.valueOf(records.get(0)) == id && newRecord != null) {
                    records = newRecord;
                } else if(Integer.valueOf(records.get(0)) == id && newRecord == null) {
                    line = br.readLine();
                    continue;
                }
                
                String value = convertRecordsIntoCSV(records);
                pw.println(value);
                
                line = br.readLine();
            }
            
            pw.flush();
            pw.close();
            
            br.close();
            
            oldFile.delete();
            tempFile.renameTo(oldFile);
            
            return true;
            
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static String convertRecordsIntoCSV(List<String> records) {
        String line = records.get(0);
        for(int i = 1; i < records.size(); i++) {
            line += "," + records.get(i);
        }
        return line;
    }
    
}
