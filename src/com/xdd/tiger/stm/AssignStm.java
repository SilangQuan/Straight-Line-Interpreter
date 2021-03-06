package com.xdd.tiger.stm;
import com.xdd.tiger.exp.*;
import com.xdd.tiger.visitor.Visitor;

public class AssignStm extends Stm {
	   String id; Exp exp;
		public AssignStm(String id,Exp exp){
			this.id=id;
			this.exp=exp;
		}
		@Override
		public void accept(Visitor v) {
			v.visitAssignStm(this);
		}

		public String getId() {
			return id;
		}

		public Exp getExp() {
			return exp;
		}
	}