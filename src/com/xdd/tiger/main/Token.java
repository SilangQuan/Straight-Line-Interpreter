package com.xdd.tiger.main;

public class Token {
	String id;
	int value;
	
	Token(String i, int v){
		id = i; value = v;
	}
	
	public void update(String i, int v)
	{
		id = i;
		value = v;
	}
	
}

