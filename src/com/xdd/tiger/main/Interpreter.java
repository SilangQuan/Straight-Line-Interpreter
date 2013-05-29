package com.xdd.tiger.main;

import java.util.ArrayList;
import java.util.Hashtable;

import com.xdd.tiger.exp.*;
import com.xdd.tiger.stm.*;
import com.xdd.tiger.visitor.ArgsVisitor;

public class Interpreter {
	private static ArgsVisitor argsVisitor;
	//Use Hashtabl to speedup search task
	//Hashtable<String,Integer>  tokenList = new Hashtable<String,Integer>();
	ArrayList<Token> tokenList=new ArrayList<Token>();

	//Get maxargs of printStm
	public int maxargs(Stm s) {
		argsVisitor = new ArgsVisitor();
		s.accept(argsVisitor);
		return argsVisitor.getArgs();
	}

	//Interpreter of everyStm
	public void interpStm(Stm s)
	{
		Token token;
		if(s instanceof CompoundStm)
		{
			interpStm(((CompoundStm) s).getStm1());	//Recursion resolve
			interpStm(((CompoundStm) s).getStm2());	
		} else if (s instanceof AssignStm) {
			AssignStm as = (AssignStm) s;
			int result = interpExp(as.getExp());	//Get value of expression
			token = new Token(as.getId(), result);	
			tokenList.add(token);
		} else if (s instanceof PrintStm) {

			interpExpList(((PrintStm) s).getList());	
		}
	}
	
	//Interpreter of every Exp
	private int interpExp(Exp e)
	{
		int result = 0;
		if(e instanceof IdExp)
		{
			result = lookup(((IdExp)e).getId());
		} else if (e instanceof NumExp){
			result = ((NumExp) e).getNum();	
		} else if (e instanceof OpExp) {
			OpExp oExp = (OpExp) e;
			int left = interpExp(oExp.getExp1());	
			int right = interpExp(oExp.getExp2());	
			switch (oExp.getOp()) {	
			case OpExp.Plus:
				result = left + right;
				break;
			case OpExp.Minus:
				result = left - right;
				break;
			case OpExp.Times:
				result = left * right;
				break;
			case OpExp.Div:
				result = left / right;
				break;
			default:
				System.out.println("Unknown Operator！");	
			}
		} else if (e instanceof EseqExp) {
			interpStm(((EseqExp) e).getStm());	
			result = interpExp(((EseqExp) e).getExp());	
		}
		return result;
	}

	//Interpreter of every ExpList
	private void interpExpList(ExpList el)
	{
		int value;
		if (el instanceof PairExpList) {
			PairExpList pExplist = (PairExpList) el;
			value = interpExp(pExplist.getExp());	
			System.out.println(value);
			interpExpList(pExplist.getList());
		} else if (el instanceof LastExpList) {
			LastExpList lExplist = (LastExpList) el;
			value = interpExp(lExplist.getExp());	
			System.out.println(value);
		}
	}

	private int lookup(String id)
	{
		for(int i = 0; i<tokenList.size(); i++)
		{
			if(tokenList.get(i).id.equals(id))
				return tokenList.get(i).value;
		}
		System.out.print("error:Can not find value!");
		return 0;
	}



}
