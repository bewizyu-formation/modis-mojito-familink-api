package org.gestion.utils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HandleB64 {

	public static String codeB64(String tokenClear) throws UnsupportedEncodingException{
		byte[] bytes = tokenClear.getBytes("UTF-8");
		String token = Base64.getEncoder().encodeToString(bytes);
		return token;		
	}
	
	public static String decodeB64(String token){
		byte[] tokenBytes = Base64.getDecoder().decode(token);
		String tokenClear = new String(tokenBytes, StandardCharsets.UTF_8);
		return tokenClear;		
	}
	
}
