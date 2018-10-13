package com.github.haocen2004;

import java.io.BufferedReader;
import java.io.*;
import java.net.*; 
import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		
		Boolean get = false; 
		String UserName = null; 
		int i = 0;
		System.out.println("Copyright By Hao_cen 2018 ");
		System.out.println("Wait For System Boot ...");

		while (get=true){
			try{
				
				if (args[i] != null && args[i].length() != 0 ){
			
					if (args[i].equalsIgnoreCase("-userid")){
				
						System.out.println("User Name By String is " + args[i+1] );
						UserName = args[i+1];
						break;
				
					}
			
				}else{
				
					break;
				
					}	
				
				i++;
				
				
				}catch (ArrayIndexOutOfBoundsException e){
					
					System.out.println("Without Start Args");
					break;
					
					}

			}
		get = false;
		while(get = true){

		if (UserName != null && UserName.length() != 0 ){
			
			System.out.println("Has Data");
			String Data = httpGetSend("https://api.mojang.com/users/profiles/minecraft/"+UserName,"");
			System.out.println(Data);
			
			}else{
				
				Scanner in = new Scanner(System.in);		
				System.out.print("Pless enter your Minecraft User Name:  ");
				UserName = in.nextLine();
				
				}

		
		
		if (UserName != null && UserName.length() != 0 ){
			
			System.out.println("You have printed "+ UserName );
			String Data = httpGetSend("https://api.mojang.com/users/profiles/minecraft/"+UserName,"");
			System.out.println(Data);
			get = true;
			break;
			
			}else{
				
				System.out.println("error");		
				
				}
				
							
			}
	}
	
	public static String httpGetSend(String url, String param) {
				
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
