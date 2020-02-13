package fdmgroup;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Solver {

	private static final int MAX_BOARD_SIZE = 9;

	public void printBoard(int[][] board) {
		for (int[] row : board) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println("");
		}

	}

	public boolean allValuesAreDistinct(int[] is) {
		// TODO Auto-generated method stub

		Set<Integer> intSet = new HashSet<>();

		for (int i : is) {
			intSet.add(i);
		}

		return intSet.size() == MAX_BOARD_SIZE;
	}

	public boolean allValuesInRange(int[] is) {
		// TODO Auto-generated method stub

		for (int i : is) {

			if (i < 1 || i > MAX_BOARD_SIZE)
				return false;

		}

		return true;

	}

	public int[][] transposeBoard(int[][] tempRow) {

		int[][] resultBoard = new int[MAX_BOARD_SIZE][MAX_BOARD_SIZE];

		for (int i = 0; i < MAX_BOARD_SIZE; i++) {
			for (int j = 0; j < MAX_BOARD_SIZE; j++) {
				resultBoard[j][i] = tempRow[i][j];

			}

		}

		return resultBoard;
	}

	public boolean checkSizeIsMax(int[] is) {
		// TODO Auto-generated method stub
		return is.length == MAX_BOARD_SIZE;
	}

	public boolean validateRow(int[] tempRow) {
		return allValuesAreDistinct(tempRow) && checkSizeIsMax(tempRow) && allValuesInRange(tempRow);
	}

	public boolean gridCheck(int[][] unitBoard) {
		int[] smallArr = new int[MAX_BOARD_SIZE];
		if (!GeneralGridCheck(unitBoard, smallArr, 0, 2, 0, 2)) {
			return false;
		}
		if (!GeneralGridCheck(unitBoard, smallArr, 0, 2, 3, 5))
			return false;
		if (!GeneralGridCheck(unitBoard, smallArr, 0, 2, 6, 8))
			return false;
		if (!GeneralGridCheck(unitBoard, smallArr, 3, 5, 0, 2))
			return false;
		if (!GeneralGridCheck(unitBoard, smallArr, 3, 5, 3, 5))
			return false;
		if (!GeneralGridCheck(unitBoard, smallArr, 3, 5, 6, 8))
			return false;
		if (!GeneralGridCheck(unitBoard, smallArr, 6, 8, 0, 2))
			return false;
		if (!GeneralGridCheck(unitBoard, smallArr, 6, 8, 3, 5))
			return false;
		if (!GeneralGridCheck(unitBoard, smallArr, 6, 8, 6, 8))
			return false;

		return true;

	}

	public boolean GeneralGridCheck(int[][] unitBoard, int[] smallArr, int aPoint, int bPoint, int cPoint, int dPoint) {
		int ind = 0;
		for (int i = aPoint; i <= bPoint; i++) {
			for (int j = cPoint; j <= dPoint; j++) {
				smallArr[ind++] = unitBoard[i][j];
			}

		}
		return validateRow(smallArr);
	}

	public int[][] constructBoard(String fileLocation) throws Exception {
		String[] number;
		int[][] board = new int[MAX_BOARD_SIZE][MAX_BOARD_SIZE];
		File file = new File(fileLocation);
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int rowNumber = 0;
		while ((line = br.readLine()) != null) {
			number = line.split(",");

			if (number.length != MAX_BOARD_SIZE) {
//				System.err.println("boards row/column index " +(rowNumber+1) +" size is " + number.length + " Invalid board ");
				return null;
			}

			for (int columnNumber = 0; columnNumber < MAX_BOARD_SIZE; columnNumber++) {
				board[rowNumber][columnNumber] = Integer.parseInt(number[columnNumber]);
			}
			rowNumber++;
		}
		return board;

	}

}
