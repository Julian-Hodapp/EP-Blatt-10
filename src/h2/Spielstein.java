package h2;

public class Spielstein {
	private int currentRow;
	private int currentCol;
	private Spielbrett brett;
	
	public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
		this.currentCol = indexCol;
		this.currentRow = indexRow;
		this.brett = brett;
	}
	
	private boolean movesOut() {
		char dir = brett.getBrett()[currentRow][currentCol].getDirection();
		int dim = brett.getDim();
		
		return (dir == 'U' && currentRow == 0)
			|| (dir == 'D' && currentRow == dim - 1)
			|| (dir == 'L' && currentCol == 0)
			|| (dir == 'R' && currentCol == dim - 1);
	}
	
	public void go(int n) {
		while(n != 0) {
			char dir = brett.getBrett()[currentRow][currentCol].getDirection();
			boolean boese = brett.getBrett()[currentRow][currentCol].isBoese();
			
			if(!boese && !movesOut()) {
				if(dir == 'U') {
					currentRow--;
				}
				if(dir == 'D') {
					currentRow++;
				}
				if(dir == 'L') {
					currentCol--;
				}
				if(dir == 'R') {
					currentCol++;
				}
			}
			n--;
		}
	}
	
	//getters & setters
	public int getCurrentRow() {
		return currentRow;
	}
	
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	
	public int getCurrentCol() {
		return currentCol;
	}
	
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
	
	public Spielbrett getBrett() {
		return brett;
	}
	
	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}
}
