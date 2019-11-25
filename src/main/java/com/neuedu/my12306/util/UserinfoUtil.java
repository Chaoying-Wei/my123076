package com.neuedu.my12306.util;

public class UserinfoUtil {
	public static String getCardType(String cardType) {
		if(cardType==null) {
			return "N/A";
		}
		switch (cardType) {
		case "1":
			return "二代身份证";
		case "C":
			return "港澳通行证";
		case "G":
			return "台湾通行证";
		case "B":
			return "护照";
		default:
			return "N/A";
		}
	}

}
