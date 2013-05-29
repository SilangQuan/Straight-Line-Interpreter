package com.xdd.tiger.visitor;

import com.xdd.tiger.exp.EseqExp;
import com.xdd.tiger.exp.IdExp;
import com.xdd.tiger.exp.LastExpList;
import com.xdd.tiger.exp.NumExp;
import com.xdd.tiger.exp.OpExp;
import com.xdd.tiger.exp.PairExpList;
import com.xdd.tiger.stm.AssignStm;
import com.xdd.tiger.stm.CompoundStm;
import com.xdd.tiger.stm.PrintStm;

public class ArgsVisitor implements Visitor  {

	int max =0;
	int args = 0;
	@Override
	public void visitAssignStm(AssignStm stm) {
		// TODO Auto-generated method stub
		stm.getExp().accept(this);
	}

	@Override
	public void visitPrintStm(PrintStm stm) {
		// TODO Auto-generated method stub
		args =0;
		stm.getList().accept(this);
	}

	@Override
	public void visitCompoundStm(CompoundStm stm) {
		// TODO Auto-generated method stub
		stm.getStm1().accept(this);
		stm.getStm2().accept(this);
	}

	@Override
	public void visitIdExp(IdExp exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitNumExp(NumExp exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitOpExp(OpExp exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitEseqExp(EseqExp exp) {
		// TODO Auto-generated method stub
		exp.getStm().accept(this);
		exp.getExp().accept(this);
	}

	@Override
	public void visitLastExpList(LastExpList lastExpList) {
		// TODO Auto-generated method stub
		//LastExpList
		//System.out.print("args");
		args += 1;
		if(max < args) max = args;
	}

	@Override
	public void visitPairExpList(PairExpList pairExpList) {
		// TODO Auto-generated method stub
		//System.out.print("args");
		//args += 1;
		args += 1;
		pairExpList.getExp().accept(this);
		pairExpList.getList().accept(this);
	}
	
	public int getArgs()
	{
		return max;
	}

}
