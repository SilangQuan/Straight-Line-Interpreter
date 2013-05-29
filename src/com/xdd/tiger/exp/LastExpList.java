package com.xdd.tiger.exp;

import com.xdd.tiger.visitor.Visitor;

public class LastExpList extends ExpList {
	Exp head; 

	public LastExpList(Exp h) {head=h;}

	public Exp getExp() {
		return head;
	}

	@Override
	public void accept(Visitor v) {
		v.visitLastExpList(this);
	}
}