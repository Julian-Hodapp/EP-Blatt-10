package h1;

public class Grid {
	private Cell[][] gridArray;
	
	public Grid(Cell[] cells, int gridRows, int gridCols) {
		Cell[][] newGridArray = new Cell[gridRows][gridCols];
		
		//Initialize empty cells
		for (int r = 0; r < gridRows; r++) {
			for (int c = 0; c < gridCols; c++) {
				newGridArray[r][c] = new Cell(r,c, false);
			}
		}
		
		//activate cells if they are within grid Array
		for (int i = 0; i < cells.length; i++) {
			//the Row and Column from the current cell
			int r = cells[i].getIndexRow();
			int c = cells[i].getIndexCol();
			
			if (r >= 0 && r < gridRows && c >= 0 && c < gridCols) {
				newGridArray[r][c].setAlive(true);
			}
		}
		
		//count living Neighbors and set next generation
		for (int r = 0; r < gridRows; r++) {
			for(int c = 0; c < gridCols; c++) {
				newGridArray[r][c].countLivingNeighbors(newGridArray);
			}
		}
		
		this.gridArray = newGridArray;
	}
	
	public void computeNextGen() {
		int rows = gridArray.length;
		//can be calculated here because it is assumed that all rows have an equal length
		int cols = rows == 0 ? 0 : gridArray[0].length;
		
		//refresh cells
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				gridArray[r][c].setAlive(gridArray[r][c].isAliveNextGen());
			}
		}
		
		//calculate new values
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				gridArray[r][c].countLivingNeighbors(gridArray);
			}
		}
	}
	
	public void computeGeneration(int n) {
		int rows = gridArray.length;
		//can be calculated here because it is assumed that all rows have an equal length
		int cols = rows == 0 ? 0 : gridArray[0].length;
		
		for (int i = 0; i < n; i++) {
			computeNextGen();
			
			//figure out if the game has already ended
			/* boolean everyCellDead = true;
			boolean noChanges = true;
			
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (gridArray[r][c].isAlive() != gridArray[r][c].isAliveNextGen() && noChanges) {
						noChanges = false;
					}
					
					if (gridArray[r][c].isAlive() && everyCellDead) {
						everyCellDead = false;
					}
					
					if(!noChanges && !everyCellDead) break;
				}
				
				if(!noChanges && !everyCellDead) break;
			}
			
			if(everyCellDead || noChanges) break; */
		}
	}

	public Cell[][] getGridArray() {
		return gridArray;
	}

	public void setGridArray(Cell[][] gridArray) {
		this.gridArray = gridArray;
	}
	
//	 Hilfsmethode: Grid ausgeben
	/* public static void printGrid(Grid grid) {
	        Cell[][] g = grid.getGridArray();
	        for (int i = 0; i < g.length; i++) {
	            for (int j = 0; j < g[0].length; j++) {
	                System.out.print(g[i][j].isAlive() ? "1 " : "0 ");
	            }
	            System.out.println();
	        } 
	  } */
}
