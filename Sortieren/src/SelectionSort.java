import java.util.ArrayList;

public class SelectionSort {

	public static ArrayList<Integer> getRandomList(int a) {
		ArrayList<Integer> random = new ArrayList<Integer>();
		for (int i = 1; i <= a; i++) {
			random.add((int) (Math.random() * 100) + 1);
		}

		return random;
	}

	public static ArrayList<Integer> selectionSort(ArrayList<Integer> a) {
		ArrayList<Integer> b = new ArrayList<Integer>();
		int s = 11111;
		int st = 0;

		while (a.size() != 0) {
			for (int i = 0; i <= a.size() - 1; i++) {
				int z = a.get(i);
				if (z < s) {
					s = z;
					st = i;
				}
				if (i == a.size() - 1) {
					b.add(s);
					a.remove(st);
					st = 0;
					s = 11111;
				}
			}
		}

		return b;
	}

	public static void main(String[] args) {
		int a = 10;
		ArrayList<Integer> zahl = getRandomList(a);

		long starttime = System.currentTimeMillis();

		System.out.println(selectionSort(zahl));

		long endtime = System.currentTimeMillis();
		long time = endtime - starttime;
		System.out.print("Dauer: ");
		System.out.println(time);
	}
}