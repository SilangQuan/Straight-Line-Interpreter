package com.xdd.tiger.main;

import com.xdd.tiger.visitor.*;
public class Main {
	
	public static void main(String args[]) throws java.io.IOException {
		Interpreter interp = new Interpreter();
		interp.interpStm(prog.prog);
		System.out.println("Maxargs: "+interp.maxargs(prog.prog));
	}

}
