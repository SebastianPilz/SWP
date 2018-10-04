
class Fakultaet {

	public static double berFak(double a) {
		// iterativ
		double b = 1;
		for (double i = 1; i <= a; i++) {
			b = b * i;
		}

		return b;
	}

	public static double faculty(double a) {
		// rekursiv
		if (a == 1) {
			return 1;
			// Abbruch
		}

		return a * faculty(a - 1);
	}

	public static double fac(double a, double b) {
		// End Rekursion
		if (a == 1) {
			return b;
		}

		return fac(a - 1, b * a);
	}
	
	public static double fac(double a) {
		return fac(a, 1);
	}

	public static void main(String[] args) {
		double a = 100;
		
		double starttime = System.currentTimeMillis();
		
		System.out.println(berFak(a));
		
		double endtime = System.currentTimeMillis();
		System.out.print("Dauer: ");
		System.out.println(endtime - starttime);
		
		starttime = System.currentTimeMillis();
		
		System.out.println(faculty(a));
		
		endtime = System.currentTimeMillis();
		System.out.print("Dauer: ");
		System.out.println(endtime - starttime);
		
		starttime = System.currentTimeMillis();
		
		System.out.println(fac(a));
		
		endtime = System.currentTimeMillis();
		System.out.print("Dauer: ");
		System.out.println(endtime - starttime);
	}
}
