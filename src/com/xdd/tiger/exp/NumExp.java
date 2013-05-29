package com.xdd.tiger.exp;

import com.xdd.tiger.visitor.Visitor;



public class NumExp extends Exp {
	   int num;
	   public NumExp(int n) {num=n;}
		@Override
		public void accept(Visitor v) {
			v.visitNumExp(this);
		}

		public int getNum() {
			return num;
		}
	}