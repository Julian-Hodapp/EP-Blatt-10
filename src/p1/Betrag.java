package p1;

public class Betrag {
	private int euro;
	private int cent;
	
	public Betrag(int euro, int cent) {
		setEuro(euro);
		setCent(cent);
	}

	public int getEuro() {
		return euro;
	}

	public void setEuro(int euro) {
		this.euro = euro;
	}

	public int getCent() {
		return cent;
	}

	public void setCent(int cent) {
		int newCent = cent + this.cent;
		
		int addEuro = newCent / 100;
		int addCent = newCent % 100;
		
		this.euro += addEuro;
		this.cent = addCent;
	}
	
	
}
