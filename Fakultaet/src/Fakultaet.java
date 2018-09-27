
class Fakultaet {
	
	public static int berFak(int a) {
		int b = 1;
		for (int i = 1; i <= a; i++) {
			b = b * i;
		}
		return b;
	}
	
	public static int faculty (int n) {
		if ( n == 1) {
			return 1;
			//Abbruch
		}
		return n * faculty(n-1);
	}
	
	public static void main(String[] args) {
		int z = 6;
		System.out.println(berFak(z));
		System.out.println(faculty(z));
	}
}