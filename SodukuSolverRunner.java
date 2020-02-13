package fdmgroup;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;

public class SodukuSolverRunner {

	private static final int MAX_BOARD_SIZE = 9;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// int counter = 0;
		// File folder = new File("C:\\Users\\brian.luna\\Desktop\\boards");
		// for (File s : folder.listFiles()) {
		//
		// Solver solver = new Solver();
		// try {
		// if (solver.constructBoard(s.getAbsolutePath()) == null) {
		// System.out.println("Invalidate Board");
		// if (counter < s.length())
		// continue;
		// }
		//
		// // Read First to see if the file will exist
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// System.err.println("Problem with file");
		// if (counter < s.length())
		// continue;
		// System.exit(-1);
		// }
		// int[][] board = solver.constructBoard(s.getAbsolutePath());
		//
		// // we know the file exist and we now get a board back
		// int[] resRow = new int[9];
		//
		// if (!solver.gridCheck(board)) {
		// System.out.println("Invalidate grid");
		// if (counter < s.length())
		// continue;
		// System.exit(-1);
		//
		// }
		//
		// for (int runcount = 0; runcount < 2; runcount++) {
		// for (int i = 0; i < 9; i++) {
		// for (int j = 0; j < 9; j++) {
		// resRow[j] = board[j][i];
		// }
		//
		// if (!solver.validateRow(resRow)) {
		// System.out.println("Invalidate row");
		// if (counter < s.length())
		// continue;
		// System.exit(-1);
		// }
		// }
		//
		// board = solver.transposeBoard(board);
		//
		// // board = solver.transposeBoard(tempRow)
		//
		// }
		// // we have checked the board normally against rows
		// // we can transpose the board and test again for the normal boards
		// // columns
		//
		// // validation for both rows and columns complete.
		// // validate the sub grids
		//
		// System.out.println("Solution is valid");
		// }
		// System.exit(0);

		int[][] goodBoard = { { 0, 8, 3, 9, 2, 1, 6, 0, 7 }, { 9, 6, 7, 3, 4, 5, 8, 2, 1 },
				{ 2, 5, 1, 8, 7, 6, 4, 9, 3 }, { 0, 4, 8, 1, 3, 2, 9, 7, 6 }, { 7, 2, 0, 5, 6, 4, 1, 3, 8 },
				{ 1, 3, 6, 7, 9, 8, 2, 4, 5 }, { 3, 7, 2, 6, 8, 0, 5, 1, 4 }, { 8, 1, 4, 2, 5, 3, 0, 6, 9 },
				{ 6, 9, 5, 4, 1, 7, 3, 8, 0 } };

		System.out.println("making a solution to a board now");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");

		Object[][] goodBoardOV = new Object[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				goodBoardOV[i][j] = Integer.valueOf(goodBoard[i][j]);
			}
		}

		SolutionBuild sb = new SolutionBuild();
		Object[] resRow2 = new Object[9];

		// ----------------------------SOLVE----------------

		boolean Solve = false;
		int count = 0;
		while (Solve == false) {
			Solve = true;

			System.out.println("itteration number : " + count);
			count++;

			for (int runcount = 0; runcount < 2; runcount++) {

				for (int j = 0; j < 9; j++) {
					for (int i = 0; i < 9; i++) {
						resRow2[i] = goodBoardOV[j][i];
					}

					sb.printBoard(goodBoardOV);
					resRow2 = sb.generatePossibleSoltionsListInLine(resRow2);
					resRow2 =sb.DeletFromList(resRow2);
					sb.UpdateListToInteger(resRow2);
					for (int K = 0; K < 9; K++) {
						goodBoardOV[j][K] = resRow2[K];
					}
					// resRow2 = sb.generatePossibleSoltionsListInLine(resRow2);
					// sb.UpdateListToInteger(resRow2);
					// goodBoardOV[j][i] = resRow2[j];
					//
					sb.printBoard(goodBoardOV);
					// System.out.println("Press Any Key To Continue...");
					// new java.util.Scanner(System.in).nextLine();

				}

				goodBoardOV = sb.transposeBoard(goodBoardOV);
				sb.printBoard(goodBoardOV);
			}

			goodBoardOV = sb.GridFillerForBoard(goodBoardOV);

			sb.printBoard(goodBoardOV);
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (goodBoardOV[j][i].getClass().equals(ArrayList.class)) {
						Solve = false;
					}
				}
			}
			{

			}
		}
	}
}
