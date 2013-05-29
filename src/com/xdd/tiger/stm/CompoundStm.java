package com.xdd.tiger.stm;

import com.xdd.tiger.visitor.Visitor;

public class CompoundStm extends Stm {
	   Stm stm1, stm2;
	   public CompoundStm(Stm s1, Stm s2) {stm1=s1; stm2=s2;}
		@Override
		public void accept(Visitor v) {
			v.visitCompoundStm(this);
		}

		public Stm getStm1() {
			return stm1;
		}

		public Stm getStm2() {
			return stm2;
		}

	}