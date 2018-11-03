package com.github.haocen2004.core;

import com.github.haocen2004.net.HttpsSendGet;

public class UUIDtoProfile {

	public static String UtD(String UUID) {

		String result;
		try {
			result = HttpsSendGet.send("https://sessionserver.mojang.com/session/minecraft/profile/" + UUID, "");
		} catch (Exception e) {

			System.out.println("NetWork Error!");
			return "";

		}
		return result;
	}
}
