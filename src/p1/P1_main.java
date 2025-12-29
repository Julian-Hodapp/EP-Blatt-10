package p1;

public class P1_main {
	public static void main(String[] args) {
		Betrag a = new Betrag(13,60);
		Betrag b = new Betrag(14,80);
		
		Betrag summe1 = summe(a,b);
		
		System.out.println(summe1.getEuro());
		System.out.println(summe1.getCent());
	}
	
	public static Betrag summe(Betrag a, Betrag b) {
		return new Betrag(a.getEuro() + b.getEuro(), a.getCent() + b.getCent());
	}
}
