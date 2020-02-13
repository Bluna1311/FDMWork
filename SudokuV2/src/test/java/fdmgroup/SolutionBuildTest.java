package fdmgroup;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SolutionBuildTest {
	private SolutionBuild solutionBuild;
	private static final int MAX_BOARD_SIZE = 9;
	
	private final int[][] goodBoard = { { 0, 8, 3, 9, 2, 1, 6, 5, 7 }, { 9, 6, 7, 3, 4, 5, 8, 2, 1 },
			{ 2, 5, 1, 8, 7, 6, 4, 9, 3 }, { 5, 4, 8, 1, 3, 2, 9, 7, 6 }, { 7, 2, 9, 5, 6, 4, 1, 3, 8 },
			{ 1, 3, 6, 7, 9, 8, 2, 4, 5 }, { 3, 7, 2, 6, 8, 9, 5, 1, 4 }, { 8, 1, 4, 2, 5, 3, 7, 6, 9 },
			{ 6, 9, 5, 4, 1, 7, 3, 8, 2 } };
	
	
	// Lets denote 0 as the empty space.
	
	@Before
	public void setUp() throws Exception {
		solutionBuild = new SolutionBuild();
	}
	
	@Test
	public void Simple1ElementMissing() {
		Object[] list = solutionBuild.generatePossibleSoltionsListInLine(new Object[]  { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
		list[0].getClass().equals(ArrayList.class);
		assertEquals(ArrayList.class,list[0].getClass());
	}
	
	@Test
	public void Simple1ElementMissingListHasOnly1Element() {
		Object[] list = solutionBuild.generatePossibleSoltionsListInLine(new Object[]  { 0, 1, 2, 3, 4, 5, 6, 7, 8 });
		assertEquals("[9]",list[0].toString());
	}
//	@Test
//	public void Simple1ElementMissingListHasOnly1ElementInTheMiddle() {
//		Object[] list = solutionBuild.generatePossibleSoltionsListInLine(new Object[]  { 9, 1, 2, 3, 0, 5, 6, 7, 8 });
//		assertEquals("[4]",list[4].toString());
//	}
//	@Test
//	public void Simple1ElementMissingListHasOnly1ElementInTheEnd() {
//		Object[] list = solutionBuild.generatePossibleSoltionsListInLine(new Object[]  { 9, 1, 2, 3, 8, 5, 6, 7, 0 });
//		assertEquals("[4]",list[8].toString());
//	}
//	@Test
//	public void Simple2ElementMissingList() {
//		Object[] list = solutionBuild.generatePossibleSoltionsListInLine(new Object[]  { 0, 1, 2, 3, 8, 5, 6, 7, 0 });
//		assertEquals("[4, 9]",list[0].toString());
//	}
//	@Test
//	public void Simple2ElementMissingListp2() {
//		Object[] list = solutionBuild.generatePossibleSoltionsListInLine(new Object[]  { 0, 1, 2, 3, 8, 5, 6, 7, 0 });
//		assertEquals("[4, 9]",list[8].toString());
//	}
//	@Test
//	public void Simple5ElementMissingList() {
//		Object[] list = solutionBuild.generatePossibleSoltionsListInLine(new Object[]  { 0, 1, 2, 0, 8, 0, 6, 0, 0 });
//		assertEquals("[3, 4, 5, 7, 9]",list[8].toString());
//	}
//	@Test
//	public void UpdateRowFromListToIntegerIfListIsSingle() {
//		Object[] list = solutionBuild.generatePossibleSoltionsListInLine(new Object[]  {  0, 1, 2, 3, 4, 5, 6, 7, 8 });
//		list = solutionBuild.UpdateListToInteger(list);
//		assertEquals(9,list[0]);
//	}
//	
//	
//	
	} 
	
	
	
	
	

