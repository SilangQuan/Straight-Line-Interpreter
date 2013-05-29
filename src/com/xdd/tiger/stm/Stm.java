package com.xdd.tiger.stm;

import com.xdd.tiger.visitor.Visitor;

public abstract class Stm {
	public abstract void accept(Visitor v); 
}