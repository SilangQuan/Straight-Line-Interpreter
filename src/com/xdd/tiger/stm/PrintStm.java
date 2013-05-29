package com.xdd.tiger.stm;

import com.xdd.tiger.exp.ExpList;
import com.xdd.tiger.visitor.Visitor;

public class PrintStm extends Stm {
	   ExpList exps;
	   public PrintStm(ExpList e) {exps=e;}
		@Override
		public void accept(Visitor v) {
			v.visitPrintStm(this);
		}

		public ExpList getList() {
			return exps;
		}
	}