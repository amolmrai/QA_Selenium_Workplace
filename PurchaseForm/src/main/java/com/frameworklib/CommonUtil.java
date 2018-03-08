package com.frameworklib;

public class CommonUtil {
	public String Macys;
	public String strLocKey;
	public String strLocValue;
	
	public CommonUtil(String strLocator) {
		int i=0;
		System.out.println("returning words:");
		for(String w:strLocator.split(",",0)){
		System.out.println(w);
		if(i==0) {
			this.setStrLocKey(w);
			i++;
		}else
			this.setStrLocValue(w);
		}
	}
	
	public String getStrLocKey() {
		return strLocKey;
	}
	public void setStrLocKey(String strLocKey) {
		this.strLocKey = strLocKey;
	}
	public String getStrLocValue() {
		return strLocValue;
	}
	public void setStrLocValue(String strLocValue) {
		this.strLocValue = strLocValue;
	}
	
	
	
}
