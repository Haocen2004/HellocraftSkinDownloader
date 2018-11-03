package com.github.haocen2004.core;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileToUrl {
	
	public static String DtS(String profile) {
		String result;
		try {

			JSONObject jsonObject2 = new JSONObject(profile);
			JSONArray properties = jsonObject2.getJSONArray("properties");
			JSONObject info = properties.getJSONObject(0);
			String value = info.getString("value");
			byte[] asBytes = java.util.Base64.getDecoder().decode(value);
			String uncode = new String(asBytes, "utf-8");
			System.out.println(uncode);
			JSONObject jsonObject3 = new JSONObject(uncode);
			JSONObject textures = jsonObject3.getJSONObject("textures");
			JSONObject skin = textures.getJSONObject("SKIN");
			result = skin.getString("url");

		} catch (Exception e) {

			System.out.println("This User used default skin.");
			return "";

		}
		return result;
	}
}
