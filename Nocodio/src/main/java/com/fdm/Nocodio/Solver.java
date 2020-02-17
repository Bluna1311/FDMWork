package com.fdm.Nocodio;
import java.lang.*;


public class Solver implements Nocodio {

	public int countNocodio(int start, int finish) {
		
		
		
		
		return 0;
	}

	public boolean OddCheck(int i) {
		
		if(i%2 ==1)
			return true;
		return false;
		
	}

	public boolean DigitCompare(int number) {
		
		int left=0,right=0;
		int order = (int) Math.log10(number); 
		int length = order;
		for(int i =0 ; i <length ;i++) {
		left = (int) (number/(Math.pow(10,order)));
		
		right = (int) (number/(Math.pow(10,order-1)));	
		right=(int) (right	- left*Math.pow(10,order-1));
		
		
		if(left > right) {
			return false;}
		number = (int) (number -(left *Math.pow(10,order)));
		order=order-1;
		}
		return true;
	}

	
	
	
}
