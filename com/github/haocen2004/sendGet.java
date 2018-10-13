package com.github.haocen2004;

import java.io.BufferedReader;
import java.io.*;
import java.net.*; 
import java.util.*;

public class sendGet{
	public static String sendGet(String url, String param) {
		
		String result = "";
        BufferedReader in = null;
        
        try {
			
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();

            for (String key : map.keySet()) {
				
                System.out.println(key + "--->" + map.get(key));
                
            }

            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            
            while ((line = in.readLine()) != null) {
				
                result += line;
                
            }
        } catch (Exception e) {
			
            System.out.println("Error!" + e);
            e.printStackTrace();
            
        }

        finally {
			
            try {
				
                if (in != null) {
                    in.close();
                    
                }
                
            } catch (Exception e2) {
				
                e2.printStackTrace();
                
            }
        }
        
        return result;
        
    }	
	
}
