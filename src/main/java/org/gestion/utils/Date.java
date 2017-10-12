package org.gestion.utils;

public class Date {
	
	public static Long getTimeStamp(Integer validConnectionMinute){
		long timeStamp = (System.currentTimeMillis() / 1000l) + validConnectionMinute*60;
		System.out.println(timeStamp);
		return timeStamp;
	}
	
	public static long getTimeUnix(){
		long timeofnow = (System.currentTimeMillis() / 1000l) ;
		System.out.println(timeofnow);
		return timeofnow;
	}
	

}
