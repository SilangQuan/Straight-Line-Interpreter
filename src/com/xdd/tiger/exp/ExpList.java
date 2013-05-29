package com.xdd.tiger.exp;

import com.xdd.tiger.visitor.Visitor;


public abstract class ExpList {
	public abstract void accept(Visitor v);
}