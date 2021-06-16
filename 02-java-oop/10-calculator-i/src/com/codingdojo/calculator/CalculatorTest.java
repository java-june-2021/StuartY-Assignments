package com.codingdojo.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calculationOne = new Calculator();
		calculationOne.setOperandOne(2.5);
		calculationOne.setOperandTwo(2.5);
		System.out.println(calculationOne.getResults());
		calculationOne.setOperation("+");
		System.out.println(calculationOne.getResults());
		calculationOne.performOperation();
		System.out.println(calculationOne.getResults());
		
		Calculator calculationTwo = new Calculator(1.2);
		calculationTwo.performOperation();
		System.out.println(calculationTwo.getResults());
		calculationTwo.setOperandTwo(50);
		calculationTwo.setOperation("+");
		calculationTwo.performOperation();
		System.out.println(calculationTwo.getResults());
		
		Calculator calculationThree = new Calculator(4.50, 3.20);
		calculationThree.setOperation("-");
		calculationThree.performOperation();
		System.out.println(calculationThree.getResults());
		

		
		
		Calculator calculationFour = new Calculator(1.1, "+" , 2.0);
		System.out.println(calculationFour.getResults());
		
		Calculator calculationFive = new Calculator(3.5, "-" , .6);
		System.out.println(calculationFive.getResults());
		
		Calculator calculationSix = new Calculator(4.1, "minus", 2.1);
		System.out.println(calculationSix.getResults());

	}

}
