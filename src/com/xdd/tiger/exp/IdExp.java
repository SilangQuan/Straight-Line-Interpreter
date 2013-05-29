package com.xdd.tiger.exp;

import com.xdd.tiger.visitor.Visitor;


public class IdExp extends Exp {
	   String id;
	   public IdExp(String i) {id=i;}
		@Override
		public void accept(Visitor v) {
			v.visitIdExp(this);
		}

		public String getId() {
			return id;
		}
	}