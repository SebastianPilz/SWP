
public class Fibonacci {

	public static int fib(int a) {
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

	public static void main(String[] args) {
		int a = 17;
		System.out.println(fib(a));
	}
}
