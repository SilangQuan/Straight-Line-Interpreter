package com.xdd.tiger.exp;


import com.xdd.tiger.stm.Stm;
import com.xdd.tiger.visitor.Visitor;


public class EseqExp extends Exp {
	   Stm stm; Exp exp;
	   public EseqExp(Stm s, Exp e) {stm=s; exp=e;}
		@Override
		public void accept(Visitor v) {
			v.visitEseqExp(this);
		}

		public Stm getStm() {
			return stm;
		}

		public Exp getExp() {
			return exp;
		}
	}
