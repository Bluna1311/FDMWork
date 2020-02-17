package com.fdm.Nocodio;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SolverTest {

	Solver solver;
	
	@Before
	public void setUp() {
	solver = new Solver();
	}
//	@Test
//	public void IsTheNumberOdd(){
//		boolean oddCheck = solver.OddCheck(9);
//		assertTrue(oddCheck);
//	}
//	@Test
//	public void IsNotTheNumberOdd(){
//		boolean oddCheck = solver.OddCheck(100);
//		assertTrue(!oddCheck);
//	}
	@Test
	public void NumberComparingfor12(){
		boolean OrderCheck = solver.DigitCompare(21);
		assertTrue(OrderCheck);
	}
//	@Test
//	public void NumberComparingfor121(){
//		boolean OrderCheck = solver.DigitCompare(121);
//		assertTrue(!OrderCheck);
//	}
	
	
	
}
