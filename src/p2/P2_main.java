package p2;

public class P2_main {
	public static void main(String[] args) {
		String2 st = new String2("abc");
		
		st.addPostfix("!");
		
		System.out.println(st);
		
		st.addPrefix("!");
		
		System.out.println(st);
	}
}
