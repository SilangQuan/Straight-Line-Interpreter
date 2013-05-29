package com.xdd.tiger.exp;

import com.xdd.tiger.visitor.Visitor;

public class PairExpList extends ExpList {
	   Exp head; ExpList tail;
	   public PairExpList(Exp h, ExpList t) {head=h; tail=t;}
		public Exp getExp() {
			return head;
		}

		public ExpList getList() {
			return tail;
		}
		
		@Override
		public void accept(Visitor v) {
			v.visitPairExpList(this);
		}
	}
