package com.github.haocen2004.main;

import java.io.File;

import com.github.haocen2004.core.ProfileToUrl;
import com.github.haocen2004.core.SkinGet;
import com.github.haocen2004.core.UUIDtoProfile;
import com.github.haocen2004.net.Download;
import com.github.haocen2004.ui.Launcher;

public class Main {

	public static void main(String[] args) {

		System.out.println("Copyright By Hao_cen 2018 ");
		System.out.println("Wait For System Boot ...");
		int i = 0;

		checkJavaFX();

		File file = new File(".\\skins");
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		while (true) {
			try {

				if (args[i] != null && args[i].length() != 0) {

					if (args[i].equalsIgnoreCase("-userid")) {

						System.out.println("User Name By String is " + args[i + 1]);
						String UserName = args[i + 1];
						SkinGet.GetSKin(UserName);
						break;

					}
					if (args[i].equalsIgnoreCase("-uuid")) {

						String UUID = args[i + 1];
						Download.single(ProfileToUrl.DtS(UUIDtoProfile.UtD(UUID)),".\\skins\\" + UUID + ".png");
						break;
					}
					if (args[i].equalsIgnoreCase("-url")) {

						String url = args[i + 1];
						Download.single(url,"url.png");
						break;
					}
				} else {

					break;

				}

				i++;

			} catch (ArrayIndexOutOfBoundsException e) {

				System.out.println("Without Start Args");
				Launcher.main(args);
				break;

			}

		}

	}

	private static void checkJavaFX() {
		try {
			Class.forName("javafx.application.Application");
		} catch (ClassNotFoundException e) {
			System.out.println("javafx none!");
		}
	}

}
