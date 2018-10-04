
public class Fibonacci {

	public static int fib(int a) {
		// rekursiv
		if (a == 0) {
			return 0;
		}
		if (a == 1) {
			return 1;
		}
		if (a == 2) {
			return 1;
		}

		return fib(a - 1) + fib(a - 2);
	}

	public static int fibo(int a, int b) {
		// End Rekursion
		if (a == 0) {
			return b;
		}
		if (a == 1) {
			return b;
		}
		if (a == 2) {
			return b;
		}

		return fibo(a - 1, b) + fibo(a - 2, b);
	}

	public static void main(String[] args) {
		int a = 7;
		System.out.println(fib(a));
		System.out.println(fibo(a, 1));
	}
}
