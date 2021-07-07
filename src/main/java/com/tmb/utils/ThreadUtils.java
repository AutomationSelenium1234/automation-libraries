package com.tmb.utils;

public class ThreadUtils {
	
	private ThreadUtils() {
	}

	private static ThreadUtils instance  = new ThreadUtils();
	public static ThreadUtils getInstance() {
		return instance;
	}

}
