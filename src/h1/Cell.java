package h1;

public class Cell {
	private int indexRow;
	private int indexCol;
	
	//state of the cell; True = alive; False = dead
	private boolean alive;
	private int numLivingNeighbors;
	private boolean isAliveNextGen;
	
	//constructors
	public Cell(int indexRow, int indexCol, boolean alive) {
		setIndexRow(indexRow);
		setIndexCol(indexCol);
		setAlive(alive);
	}
	
	public Cell(int indexRow, int indexCol) {
		setIndexRow(indexRow);
		setIndexCol(indexCol);
	}
	
	public void countLivingNeighbors(Cell[][] gridArray) {
		//has the grid to be validated
		int newCountLivingNeighbors = 0;
		int rows = gridArray.length;
		//can be calculated here because it is assumed that all rows have an equal length
		int cols = rows == 0 ? 0 : gridArray[0].length;
		
		
		for (int r = indexRow - 1; r < indexRow + 2; r++) {
			for (int c = indexCol - 1; c < indexCol + 2; c++) {
				//first we need to check if the cell is out of bounds and if it is the cell we are updating, so that we do not include them in the calculations
				if (r >= 0 && c >= 0 && r < rows && c < cols) {
					if (r == indexRow && c == indexCol) continue;
					if(gridArray[r][c].isAlive()) newCountLivingNeighbors++;
				}
			}
		}
		
		setNumLivingNeighbors(newCountLivingNeighbors);
		
		decideNextStatus();
	}
	
	private void decideNextStatus() {
		if (alive) {
			setAliveNextGen(numLivingNeighbors == 2 || numLivingNeighbors == 3);
		} else {
			setAliveNextGen(numLivingNeighbors == 3);
		}
	}
	
	
	
	//standard getters & setters
	public int getIndexRow() {
		return indexRow;
	}
	
	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}
	
	public int getIndexCol() {
		return indexCol;
	}
	
	public void setIndexCol(int indexColumn) {
		this.indexCol = indexColumn;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public int getNumLivingNeighbors() {
		return numLivingNeighbors;
	}
	
	public void setNumLivingNeighbors(int numLivingNeighbors) {
		this.numLivingNeighbors = numLivingNeighbors;
	}
	
	public boolean isAliveNextGen() {
		return isAliveNextGen;
	}
	
	public void setAliveNextGen(boolean isAliveNextGen) {
		this.isAliveNextGen = isAliveNextGen;
	}
	
}
