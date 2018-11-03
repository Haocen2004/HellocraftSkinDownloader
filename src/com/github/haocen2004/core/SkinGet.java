package com.github.haocen2004.core;

import com.github.haocen2004.net.Download;

public class SkinGet {

	public static boolean GetSKin(String UserName) {

		String UUID = NameToUUID.Ntu(UserName);
		String profile = null;
		String Skinurl = null;
		if (UUID != null && UUID.length() != 0) {
			profile = UUIDtoProfile.UtD(UUID);
			
		}

		if (profile != null && profile.length() != 0) {
			Skinurl = ProfileToUrl.DtS(profile);
		}

		if (Skinurl != null && Skinurl.length() != 0) {

			String save = ".\\skins\\" + UserName + ".png";
			if (Download.single(Skinurl, save)) {
				return true;
			}
		}
		return false;
	}

}