package org.gestion.utils;

import java.io.UnsupportedEncodingException;

public class Tokens {

	public static String generateToken(Integer userId) {

		String tokenClear = userId + "-" + Date.getTimeStamp(3);
		String token = null;
		try {
			token = HandleB64.codeB64(tokenClear);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(token);
		return token;
	}

	public static Integer getIdFromToken(String token) {
		String tokenClear = HandleB64.decodeB64(token);
		String[] parts = tokenClear.split("-");
		Integer idUser = Integer.parseInt(parts[0]);
		System.out.println(parts[0]);
		return idUser;
	}

	public static Long getTimeStampFromToken(String token) {
		String tokenClear = HandleB64.decodeB64(token);
		String[] parts = tokenClear.split("-");
		Long timeStamp = Long.parseLong(parts[1]);
		System.out.println("token time   :" + parts[1]);
		return timeStamp;
	}

	public static Boolean isValid(String token) {
		if (Date.getTimeUnix() < Tokens.getTimeStampFromToken(token)) {
			return true;
		} else {
			return false;
		}
	}

}
