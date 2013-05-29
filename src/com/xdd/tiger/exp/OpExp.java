package com.xdd.tiger.exp;

import com.xdd.tiger.visitor.Visitor;



public class OpExp extends Exp {
	   Exp left, right; int oper;
	   public final static int Plus=1;
	   public static final int Minus=2;
	   public static final int Times=3;
	   public static final int Div=4;
	   public OpExp(Exp l, int o, Exp r) {left=l; oper=o; right=r;}
	   
		@Override
		public void accept(Visitor v) {
			v.visitOpExp(this);
		}

		public Exp getExp1() {
			return left;
		}

		public Exp getExp2() {
			return right;
		}

		public int getOp() {
			return oper;
		}
		
	}
