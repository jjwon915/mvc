package kr.bit.model;

public class MyCalc {
	public int sum(int num1, int num2) {
		int result = 0;
		for(int i = num1; i<= num2; i++) {
			result += i;
		}
		return result;
	}
}
