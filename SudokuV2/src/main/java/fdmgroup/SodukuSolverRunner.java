package fdmgroup;

import static org.junit.Assert.fail;

public class SodukuSolverRunner {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		if(args.length == 0){
			System.err.println("not file passed");
		    System.err.println("usage: java SodukuSolverRunner <filename>");
		    System.exit(5);
		}

		Solver solver = new Solver();
		try {
			solver.constructBoard(args[0]);
			// Read First to see if the file will exist
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Problem with file");
			System.exit(1);
		}
		int[][] board = solver.constructBoard(args[0]); 
		
		// we know the file exist and we now get a board back
		int[] resRow = new int[9];

		
		if (!solver.gridCheck(board)) {
			System.out.println("Invalidate grid");
			System.exit(4);
			
		}
		
		
		for (int runcount = 0; runcount < 2; runcount++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					resRow[j] = board[j][i];
				}

				if (!solver.validateRow(resRow)) {
					System.out.println("Invalidate row");
					System.exit(2);
				}
			}
			
			
			
			board = solver.transposeBoard(board);

			//board = solver.transposeBoard(tempRow)
            
		}
		// we have checked the board normally against rows
		// we can transpose the board and test again for the normal boards
		// columns

	
		// validation for both rows and columns complete.
		// validate the sub grids

	
		
		System.out.println("Solution is valid");
		System.exit(0);

	}

}
