package pDreieck;

public class pDreieck {

	public static int pd(int a, int b) {
		if (b == 0) {
			return 1;
		}
		if (a == b) {
			return 1;
		}

		return pd(a - 1, b - 1) + pd(a - 1, b);
	}

	public static void main(String[] args) {
		System.out.println(pd(5, 2));

	}
}
