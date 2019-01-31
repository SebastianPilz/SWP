package fizzbuzz;

public class fizzbuzz {
	// Wenn die Zahl durch 2 geteilt werden kann fizz
	// Wenn die Zahl durch 3 geteilt werden kann buzz
	// Wenn beides zutrifft fizzbuzz 
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 2 != 0) {
				System.out.printf("%d = buzz \n", i);
			} else if (i % 2 == 0 && i % 3 != 0) {
				System.out.printf("%d = fizz \n", i);
			} else if (i % 2 == 0 && i % 3 == 0) {
				System.out.printf("%d = fizzbuzz \n", i);
			} else {
				System.out.printf("%d = %d \n", i, i);
			}
		}
	}
}