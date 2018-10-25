package com.github.haocen2004.main;



import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import org.json.*;

import com.github.haocen2004.http.HttpsSendGet;

public class Main {
	
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		
		String FirstBack =null;
		String SecondBack =null;	
		String UserName = null; 
		int i = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Copyright By Hao_cen 2018 ");
		System.out.println("Wait For System Boot ...");

		while (true){
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
		
		while(true){

		if (UserName != null && UserName.length() != 0 ){
			
			System.out.println("Has Data");
			try {
				
				FirstBack = HttpsSendGet.send("https://api.mojang.com/users/profiles/minecraft/"+UserName,"");
			
			}catch(Exception e){
				
				System.out.println("Error!"+e);
				
			}
			System.out.println(FirstBack);
			break;
			
			}else{
						
				System.out.print("Pless enter your Minecraft User Name:  ");
				UserName = in.nextLine();
				
				}

		
		if (UserName != null && UserName.length() != 0 ){
			
			System.out.println("You have printed "+ UserName );
			try {
			
				FirstBack = HttpsSendGet.send("https://api.mojang.com/users/profiles/minecraft/"+UserName,"");
				
			}catch(Exception e){
				
				System.out.println("Error!"+e);
				UserName = null;
				
				
			}

			System.out.println(FirstBack);
			break;
			
			}else{
				
				System.out.println("error");		
				UserName = null;
				
				}
				
		}
		if (FirstBack != null && FirstBack.length() != 0 ){
			
			JSONObject jsonObject = new JSONObject(FirstBack);
			String uuid = jsonObject.getString("id");
			System.out.println(uuid);
			
			try {
			
			SecondBack = HttpsSendGet.send("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid,"");
			System.out.println(SecondBack);
			} catch(Exception e) {
				
				
				
			}
			
		}else {
			
			System.out.println("NetWork Error!");
			
		}
		
		if (SecondBack != null && SecondBack.length() != 0 ){
			try {
			JSONObject jsonObject2 = new JSONObject(SecondBack);
			JSONArray properties = jsonObject2.getJSONArray("properties");
			JSONObject info = properties.getJSONObject(0);
			String value = info.getString("value");
			byte[] asBytes = java.util.Base64.getDecoder().decode(value);
			String uncode = new String(asBytes, "utf-8");
			System.out.println(uncode);
			JSONObject jsonObject3 = new JSONObject(uncode);
			JSONObject textures = jsonObject3.getJSONObject("textures");
			JSONObject skin = textures.getJSONObject("SKIN");
			String url = skin.getString("url");
			int bytesum = 0;
			int byteread = 0;
			URL dlurl = new URL(url);
			try {
				
				URLConnection conn = dlurl.openConnection();
			    InputStream inStream = conn.getInputStream();
			    FileOutputStream fs = new FileOutputStream(".\\" + UserName + ".png");
			    byte[] buffer = new byte['1'];
			    while ((byteread = inStream.read(buffer)) != -1) {
			
			    	bytesum += byteread;
			    	System.out.println(bytesum);
			    	fs.write(buffer, 0, byteread);
			    
			    }
				} catch (java.io.FileNotFoundException e) {
					
					System.out.println("FileNotFound!");
					e.printStackTrace();
			
				} catch (java.io.IOException e) {
				
					e.printStackTrace();
				
				}
			
			System.out.println("Task Finish.");
			
			}catch (Exception e) {
			
				System.out.println("This User used default skin.");
				
			}}else {
			
			System.out.println("NetWork Error");
			
			}
		}		
	
}