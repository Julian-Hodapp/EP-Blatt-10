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
		Betrag betrag = new Betrag(0,0);
		
		b.setEuro(a.getEuro() + b.getEuro());
		b.setCent(a.getCent() + b.getCent());
		
		return betrag;
	}
}
