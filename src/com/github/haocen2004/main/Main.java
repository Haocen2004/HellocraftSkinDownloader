package com.github.haocen2004.main;

import com.github.haocen2004.cmd.SkinGet;
import com.github.haocen2004.ui.UImain;

public class Main {

	public static void main(String[] args) {

		int i = 0;
		String UserName;

		while (true) {
			try {

				if (args[i] != null && args[i].length() != 0) {

					if (args[i].equalsIgnoreCase("-userid")) {

						System.out.println("User Name By String is " + args[i + 1]);
						UserName = args[i + 1];
						SkinGet.GetSKin(UserName);
						break;

					}

				} else {

					
					break;

				}

				i++;

			} catch (ArrayIndexOutOfBoundsException e) {

				System.out.println("Without Start Args");
				break;

			}

		}
		UImain.launch();
	}

}
