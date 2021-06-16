package com.codingdojo.calculator;

import java.io.Serializable;

public class Calculator implements Serializable {
	
	private float operandOne;
	private float operandTwo;
	private String operation;
	private float result;
	

	public Calculator() {
		this.operandOne = 0.0f;
		this.operandTwo = 0.0f;
	}
	
	public Calculator(double operand) {
		this.operandOne = (float)operand;
		this.operandTwo = 0.0f;
	}
	
	public Calculator(double operand, String operator) {
		this.operandOne = (float)operand;
		setOperation(operator);
		this.operandTwo = 0.0f;
	}
	
	public Calculator(double operandOne, double operandTwo) {
		this.operandOne = (float)operandOne;
		this.operandTwo = (float)operandTwo;
	}
	
	public Calculator(double operandOne, String operator, double operandTwo) {
		this.operandOne = (float)operandOne;
		this.operandTwo = (float)operandTwo;
		setOperation(operator);
		performOperation();
		
	}
	
	public void setOperandOne(double operand){
		this.operandOne = (float)operand;
	}
	
	public void setOperandTwo(double operand){
		this.operandTwo = (float)operand;
	}
	
	public void setOperation(String operator) {
		if(operator == "+") {
			this.operation = "+";
		} else if (operator == "-") {
			this.operation = "-";
		} else {
			System.out.println("Operator must be + or -; could not set operation");
		}
	}
	
	public void performOperation() {
		if(this.operation == "+") {
			this.result = this.operandOne + this.operandTwo;
		} else if (this.operation == "-") {
			this.result = this.operandOne - this.operandTwo;
		} else {
			System.out.println("Operation not defined, returning 0");
		}
		
	}
	
	public float getResults() {
		return this.result;
	}

}
