public class EightQueens {

public int[][] Queenssolution;


public EightQueens() {

	Queenssolution = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Queenssolution[i][j] = 0;
		}
	}
}

public void solveProblem() {
	if(placeQueens(0)){
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(" " + Queenssolution[i][j]);
						}
						System.out.println();
					}
				}
				else
			{
		System.out.println("THERE IS NO SOLUTION EXISTS");
		}
}
public boolean placeQueens(int queen) {
	// will place the Queens one at a time, for column wise
		if(queen==8){
	//if we are here that means we have solved the problem
			return true;
		}	
		for (int row = 0; row < 8; row++) {
			// check if queen can be placed row,col
				if (canPlace(Queenssolution, row, queen)) {
					// place the queen
					Queenssolution[row][queen] = 1;
						// solve for next queen
						if(placeQueens(queen+1)){
							return true;
							}
						//if we are here that means above placement didn't work
						//BACKTRACK
							Queenssolution[row][queen]=0;
				}
		}
			//if we are here that means we haven't found solution
		return false;
}
// check if queen can be placed at matrix[row][column]
public boolean canPlace(int[][] matrix, int row, int column) {
// since we are filling one column at a time,
// we will check if no queen is placed in that particular row
	for (int i = 0; i < column; i++) {
		if (matrix[row][i] == 1) {
			return false;
		}
}
// we are filling one column at a time,so we need to check the upper and
// diagonal as well
// checking upper diagonal
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (matrix[i][j] == 1) {
				return false;
			}
		}
// checking lower diagonal
		for (int i = row, j = column; i < matrix.length && j >= 0; i++, j--) {
			if (matrix[i][j] == 1) {
				return false;
			}
		}
		// if we are here that means we are safe to place Queen at row,column
		return true;
	}
public static void main(String[] args) {
EightQueens q = new EightQueens();
q.solveProblem();

}

}