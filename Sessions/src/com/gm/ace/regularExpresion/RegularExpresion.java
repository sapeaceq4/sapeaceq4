package com.gm.ace.regularExpresion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpresion {
	public static void main(String[] args) {
		String str = "ksajfl989934&(*(587";
		
		String pattern = "[a-zA-Z0-9]";
		
		Pattern r = Pattern.compile(pattern);
		
		Matcher m = r.matcher(str);
		
		System.out.println(m.replaceAll(""));
	}

}
