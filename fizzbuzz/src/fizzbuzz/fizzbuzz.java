package fizzbuzz;

public class fizzbuzz {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 4 != 0) {
				System.out.printf("%d = fizz \n", i);
			} else if (i % 4 == 0 && i % 3 != 0) {
				System.out.printf("%d = buzz \n", i);
			} else if (i % 4 == 0 && i % 3 == 0) {
				System.out.printf("%d = fizzbuzz \n", i);
			} else {
				System.out.printf("%d = %d \n", i, i);
			}
		}
	}
}