package algorithms.recurssion.tictactoe;
 
public class Position {
	int Row, Col;
	
	// Class for Row and Column
		public Position(int Row, int Col) {
			this.Row = Row;
			this.Col = Col;
		}

		@Override
	    	public String toString() {
			return "[" + Row + ", " + Col + "]";
		}	


}
