package com.staticblocks;

import java.util.HashMap;
import java.util.Map;

public class Runner {
	
	public static Map<String,String> map = new HashMap<String, String>();
	
	static {
		map.put("Author", "Sampath Sankati");
	}

	public static void main(String[] args) {
		System.out.println(map);

	}

}
