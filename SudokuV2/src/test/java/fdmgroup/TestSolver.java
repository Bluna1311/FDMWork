package fdmgroup;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class TestSolver {

	private Solver solver;

	private final int[][] goodBoard = { { 4, 8, 3, 9, 2, 1, 6, 5, 7 }, { 9, 6, 7, 3, 4, 5, 8, 2, 1 },
			{ 2, 5, 1, 8, 7, 6, 4, 9, 3 }, { 5, 4, 8, 1, 3, 2, 9, 7, 6 }, { 7, 2, 9, 5, 6, 4, 1, 3, 8 },
			{ 1, 3, 6, 7, 9, 8, 2, 4, 5 }, { 3, 7, 2, 6, 8, 9, 5, 1, 4 }, { 8, 1, 4, 2, 5, 3, 7, 6, 9 },
			{ 6, 9, 5, 4, 1, 7, 3, 8, 2 } };
	
	private final int[][] badBoard = { { 4, 8, 3, 9, 2, 1, 6, 5, 7 }, { 9, 6, 7, 3, 4, 5, 8, 2, 1 },
			{ 2, 5, 1, 8, 7, 6, 4, 9, 3 }, { 5, 4, 8, 1, 3, 2, 9, 7, 6 }, { 7, 2, 9, 5, 6, 4, 1, 3, 8 },
			{ 1, 3, 6, 7, 9, 8, 2, 4, 5 }, { 3, 7, 2, -6, 8, 9, 5, 1, 4 }, { 8, 1, 4, 2, 5, 3, 7, 6, 9 },
			{ 6, 9, 5, 4, 1, 7, 3, 8, 2 } };
	
	private final int[][] unitBoard = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	
	private final int[][] longBoard = { { 4, 8, 3, 9, 2, 1, 6, 5, 7, 2 }, { 9, 6, 7, 3, 4, 5, 8, 2, 1 },
			{ 2, 5, 1, 8, 7, 6, 4, 9, 3 }, { 5, 4, 8, 1, 3, 2, 9, 7, 6 }, { 7, 2, 9, 5, 6, 4, 1, 3, 8 },
			{ 1, 3, 6, 7, 9, 8, 2, 4, 5 }, { 3, 7, 2, 6, 8, 9, 5, 1, 4 }, { 8, 1, 2, 4, 2, 5, 3, 7, 6, 9 },
			{ 6, 9, 5, 4, 1, 7, 3, 8, 2 } };
	
	private String exisitngFile = "H:\\Solution.txt";
	
	private String exisitngFileBadLong = "H:\\SolutionLong.txt";  
	
	

	@Before
	public void setUp() throws Exception {
		solver = new Solver();
	}

	@Test
	public void allZerosShouldFail() {

		boolean result = solver.allValuesAreDistinct(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 });
		assertEquals(false, result);
	}

	@Test
	public void oneTo9ShouldWork() {

		boolean result = solver.allValuesAreDistinct(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		assertEquals(true, result);
	}

	@Test
	public void allValuesBetween1And9() {

		boolean result = solver.allValuesInRange(new int[] { 1, 2, 3, -1, 5, 6, 7, 8, 9 });
		assertEquals(false, result);
	}

	@Test
	public void invalidLengthisNineWhenTooMuchData() {

		boolean result = solver.checkSizeIsMax(new int[] { 2, 31, 2, 3, -1, 5, 6, 7, 8, 9 });
		assertEquals(false, result);
	}

	@Test
	public void invalidLengthisNineWhenTooLittleData() {

		boolean result = solver.checkSizeIsMax(new int[] { 2, 31, 2 });
		assertEquals(false, result);
	}

	@Test
	public void oneTo9ShouldWorkForAllCases() {

		boolean result = solver.validateRow(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		assertEquals(true, result);
	}

	@Test
	public void oneTo9ShouldNoWorkForAllCasesWithInvalidValues() {

		boolean result = solver.allValuesInRange(new int[] { 1, 2, 3, -1, 5, 6, 7, 8, 9 });
		assertEquals(false, result);
	}

	@Test
	public void checkBoardAgainstValidBoard() {

		boolean boardIsHealty = true;

		for (int[] crow : goodBoard) {
			if (!solver.validateRow(crow)) {
				fail("Invalidate row");
			}
		}

		assertTrue(boardIsHealty);

	}

	@Test
	public void checkRowWithGoodBoard() {
		
		boolean boardIsHealty = true;
		
		int[] resRow = new int[9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				resRow[j] = goodBoard[j][i];
			}
			
			if (!solver.validateRow(resRow)) {
				fail("Invalidate row");
			}
		}
		
		assertTrue(boardIsHealty);

	}
	
	

	
	
	@Test
	public void checkcolumnWithGoodBoard() {
		
		boolean boardIsHealty = true;
		
		int[] resRow = new int[9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				resRow[j] = goodBoard[i][j];
			}
			
			if (!solver.validateRow(resRow)) {
				fail("Invalidate row");
			}
		}
		
		assertTrue(boardIsHealty);

	}
	
	
	@Test
	public void checkRowWithBadBoard() {
		
		boolean boardIsHealthy = true;
		
		int[] resRow = new int[9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				resRow[j] = badBoard[j][i];
			}
			
			if (!solver.validateRow(resRow)) {
				boardIsHealthy = false;
			}
		}
		
		assertEquals(false, boardIsHealthy);

	}
	@Test
	public void checkSubGridWithUnitBoard() {
		
		boolean result = solver.gridCheck(unitBoard);
		
		assertEquals(false, result);
	}
	@Test
	public void checkSubGridWithgoodBoard() {
		
		boolean result = solver.gridCheck(goodBoard);
		
		assertEquals(true, result);
	}
	@Test
	public void checkSubGridWithBadBoard() {
		
		boolean result = solver.gridCheck(badBoard);
		
		assertEquals(false, result);
	}
	@Test
	public void ReadGoodFile() throws Exception{
		int[][] result = solver.constructBoard(exisitngFile);
		assertNotNull(result);
	}
	
	@Test(expected = FileNotFoundException.class)
	public void ReadBadFile() throws Exception{
		int[][] result = solver.constructBoard("H:\\ThisLocationDoesNotEvenExist.txt");
		
	}
	
	@Test
	public void checkIfBoardisFullGridValid() {
		
		boolean result = solver.gridCheck(goodBoard);
		
		assertEquals(true, result);
	}
	
	@Test
	public void checkIfBoardisValidForColumns() {
		
		int [][]transposedGrid = solver.transposeBoard(goodBoard);
		
		boolean boardIsHealty = true;
		
		int[] resRow = new int[9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				resRow[j] = transposedGrid[i][j];
			}
			
			if (!solver.validateRow(resRow)) {
				fail("Invalidate row");
			}
		}
		
		assertTrue(boardIsHealty);
		

	}

	
}
		
	



