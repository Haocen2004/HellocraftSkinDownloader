package com.github.haocen2004.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Download {

	public static boolean single(String url, String save) {

		File file = new File(save);
		if (file.exists()) {
			file.delete();
		}
		int bytesum = 0;
		int byteread = 0;

		try {
			URL dlurl = new URL(url);
			URLConnection conn = dlurl.openConnection();
			InputStream inStream = conn.getInputStream();
			FileOutputStream fs = new FileOutputStream(save);
			byte[] buffer = new byte['1'];
			while ((byteread = inStream.read(buffer)) != -1) {

				bytesum += byteread;
				System.out.println(bytesum);
				fs.write(buffer, 0, byteread);

			}
			fs.close();
			
			
		} catch (java.io.FileNotFoundException e) {

			System.out.println("FileNotFound!");
			e.printStackTrace();
			return false;

		} catch (java.io.IOException e) {

			e.printStackTrace();
			return false;

		}


		
		System.out.println("Task Finish.");
		return true;
	}
}
