package fdmgroup;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionBuild {

	
	private Object[][] backBoard = new Object[MAX_BOARD_SIZE][MAX_BOARD_SIZE] ;
	private static final int MAX_BOARD_SIZE = 9;
	ArrayList<Integer> List;

	private ArrayList listFullArray() {
		List = new ArrayList<Integer>();
		List.add(1);
		List.add(2);
		List.add(3);
		List.add(4);
		List.add(5);
		List.add(6);
		List.add(7);
		List.add(8);
		List.add(9);

		return List;
	}

	public Object[] DeletFromList(Object[] objects) {
		
		java.util.List<String> al = new ArrayList<String>();
		for(int j =0 ; j <   9 ;j++)
		{
			if(objects[j].getClass().equals(ArrayList.class)) {
				String[] a=  objects[j].toString().split(",") ;
				al = Arrays.asList(a);
				for(int i =0 ; i <9 ;i++) {
					if(al.get(j).contains(objects[i].toString())) {al.remove((objects[i]));}
				}
				
			}
			if(j==8){
				
				
			}
		}
		
		return objects;
		
		
	}
	
	public Object[] generatePossibleSoltionsListInLine(Object[] objects) {
		
		for(int i =0 ; i <   9 ;i++) {
			if (objects[i].equals(0)){
			List = new ArrayList<Integer>();
			objects[i]=listFullArray();	
			
			for(int j =0 ; j <   9 ;j++)
			{
				if(!objects[j].getClass().equals(ArrayList.class)) {
					List.remove(objects[j]);
				}
				if(j==8){
					objects[i] =List;
					
				}
			}
		}
			
	}
		return objects;	
}
	public Object[][] getBackBoard() {
		return backBoard;
	}

	public void setBackBoard(Object[][] backBoard) {
		this.backBoard = backBoard;
	}

	public Object[][] GeneralGridFiller(Object[][] Board, Object[] smallArr, int aPoint, int bPoint, int cPoint, int dPoint) {
		int ind = 0;
		
		for (int i = aPoint; i <= bPoint; i++) {
			for (int j = cPoint; j <= dPoint; j++) {
				smallArr[ind++] = Board[i][j];
			}
		}
		Object[] objects = new Object[9];
		for (int i = 0; i<9; i++)
		objects[i] = smallArr[i];
		
		objects = generatePossibleSoltionsListInLine(objects);
		int k=0;
		for (int i = aPoint; i <= bPoint; i++) {
			for (int j = cPoint; j <= dPoint; j++) {
				Board[i][j] =objects[k];
				k++;
			}
	}
		return Board;
	}
	public Object[][] GridFillerForBoard(Object[][] unitBoard) {
		Object [] smallArr = new Object[MAX_BOARD_SIZE];
		unitBoard= GeneralGridFiller(unitBoard, smallArr, 0, 2, 0, 2);
		unitBoard= GeneralGridFiller(unitBoard, smallArr, 0, 2, 3, 5);
		unitBoard=GeneralGridFiller(unitBoard, smallArr, 0, 2, 6, 8);
		unitBoard=GeneralGridFiller(unitBoard, smallArr, 3, 5, 0, 2);
		unitBoard=GeneralGridFiller(unitBoard, smallArr, 3, 5, 3, 5);
		unitBoard=GeneralGridFiller(unitBoard, smallArr, 3, 5, 6, 8);
		unitBoard=GeneralGridFiller(unitBoard, smallArr, 6, 8, 0, 2);
		unitBoard=GeneralGridFiller(unitBoard, smallArr, 6, 8, 3, 5);
		unitBoard=GeneralGridFiller(unitBoard, smallArr, 6, 8, 6, 8);
		return unitBoard;
		
	}
	public Object[][] transposeBoard(Object[][] BoardOV ) {

		Object[][] CBoardOV = new Object[9][9];
		for (int i = 0; i < MAX_BOARD_SIZE; i++) {
			for (int j = 0; j < MAX_BOARD_SIZE; j++) {
				CBoardOV[i][j] = BoardOV[j][i];
				System.out.print(CBoardOV[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println(CBoardOV);
		return CBoardOV;

		
	}

	public void printBoard(Object[][] board) {
		for (Object[] row : board) {
			for (Object col : row) {
				System.out.print(col + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	
	
	public Object[] UpdateListToInteger(Object[] object) {
		for(int i=0; i<9;i++) {
		 {
			if(object[i].toString().length() == 3) {
				object[i]=Integer.valueOf(object[i].toString().replace("[", "").replace("]", ""));
			}
		}}
		return object;
	}	
}
	
	
