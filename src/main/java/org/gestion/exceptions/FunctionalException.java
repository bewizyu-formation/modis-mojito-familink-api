package org.gestion.exceptions;

import org.json.JSONObject;


public class FunctionalException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -528098763779848071L;
	private String method;
	private String message;

	/**
	 * @param message
	 */
	public FunctionalException(String method, String message) {
		super();
		this.method = method;
		this.message = message;
	}

	public String jsonResponse (){
		JSONObject json = new JSONObject();
		json.put("method", this.method);
		json.put("statut", "failed");
		json.put("description", this.message);
		return json.toString();
	}
}
