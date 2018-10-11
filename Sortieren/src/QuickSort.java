import java.util.ArrayList;

public class QuickSort {

	public static ArrayList<Integer> getRandomList(int a) {
		ArrayList<Integer> random = new ArrayList<Integer>();
		for (int i = 1; i <= a; i++) {
			random.add((int) (Math.random() * 100) + 1);
		}
		
		return random;
	}

	public static ArrayList<Integer> quickSort(ArrayList<Integer> a) {
		// Aufteilen in neue Listen
		ArrayList<Integer> z1 = new ArrayList<Integer>();
		ArrayList<Integer> z2 = new ArrayList<Integer>();

		if (a.size() == 1 || a.size() == 0) {
			return a;
		}

		int b = a.get(0);

		for (int i = 1; i <= a.size() - 1; i++) {
			int c = a.get(i);

			if (c < b) {
				z1.add(c);
			} else if (c >= b) {
				z2.add(c);
			}
		}

		ArrayList<Integer> z1sorted = quickSort(z1);
		// System.out.println(z1sorted);
		ArrayList<Integer> z2sorted = quickSort(z2);
		// System.out.println(z2sorted);
		z1sorted.add(b); // Beseitigt StackOverflow
		z1sorted.addAll(z2sorted);
		// Zusammenfügen der Zwei aufgeteilten sortierten Listen
		return z1sorted;
	}

	public static ArrayList<Integer> qSort(ArrayList<Integer> a, int b, int c) {
		// Ohne ArrayLists zu erstellen, alles in einer ArrayList lösen
		if (b == c) {
			return a;
		}

		int d = a.get(b);
		int s = 0;

		for (int i = b + 1; i <= c; i++) {
			int e = a.get(i);

			if (e < d) {
				a.remove(e);
				a.remove(d);
				a.add(d, i);
				a.add(e, b);
				s = i;
			}
		}

		return qSort(a, b, s);
	}

	public static void main(String[] args) {
		int a = 10;
		ArrayList<Integer> zahlen = getRandomList(a);
		System.out.print("Originale Liste : ");
		System.out.println(zahlen);
		System.out.print("Erste Version : ");
		System.out.println(quickSort(zahlen));
		System.out.print("Zweite Version : ");
		System.out.println(qSort(zahlen, 0, zahlen.size() - 1));

	}
}
