package com.github.haocen2004;

import com.github.haocen2004.*;

import java.util.*;

public class Main {
	
	
	public static void main (String[] args) {

		System.out.println("Copyright By Hao_cen 2018 ");
		System.out.println("Wait For System Boot ...");

		for (int i=0; i <=5; i++){
			try{
							
				if (args[i] != null && args[i].length() != 0 ){
			
					if (args[i].equalsIgnoreCase("-userid")){
				
						System.out.println("User Name By String is " + args[i+1] );
						break;
				
					}
			
				}else{
				
					break;
				
					}	
				
				}catch (ArrayIndexOutOfBoundsException e){
					
					System.out.println("Without Start Args");
					break;
					
					}

			}
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Pless enter your Minecraft User Name:  ");
		String UserName = in.nextLine();
		
		
		if (UserName != null && UserName.length() != 0 ){
			
			System.out.println("You have printed "+ UserName );
			
			}else{
				
				System.out.println("error");		
				
				}
	}

}
