package com.github.haocen2004.core;

import org.json.JSONObject;

import com.github.haocen2004.net.HttpsSendGet;

public class NameToUUID {

	public static String Ntu(String UserName) {
		String result = null;
		String uuid = null;
		try {

			result = HttpsSendGet.send("https://api.mojang.com/users/profiles/minecraft/" + UserName, "");
			if (result != null && result.length() != 0) {
				JSONObject jsonObject = new JSONObject(result);
				uuid = jsonObject.getString("id");

			}
			return uuid;
		} catch (Exception e) {

			System.out.println("Error!" + e);
			return "";

		}
	}
}
