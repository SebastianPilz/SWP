import java.util.ArrayList;

public class SelectionSort {

	public static ArrayList<Integer> getRandomList(int a) {
		ArrayList<Integer> random = new ArrayList<Integer>();
		for (int i = 1; i <= a; i++) {
			random.add((int) (Math.random() * 100) + 1);
		}
		return random;
	}

	public static void main(String[] args) {

		int s = 11111;
		int st = 0;

		ArrayList<Integer> zahlen = new ArrayList<Integer>();
		ArrayList<Integer> sortiert = new ArrayList<Integer>();

		zahlen.add(8);
		zahlen.add(4);
		zahlen.add(3);
		zahlen.add(7);
		zahlen.add(12);
		zahlen.add(17);
		zahlen.add(2);

		ArrayList<Integer> zahl = getRandomList(10);

		long starttime = System.currentTimeMillis();

		while (zahl.size() != 0) {
			for (int i = 0; i <= zahl.size() - 1; i++) {
				int z = zahl.get(i);
				if (z < s) {
					s = z;
					st = i;
				}
				if (i == zahl.size() - 1) {
					sortiert.add(s);
					zahl.remove(st);
					st = 0;
					s = 11111;
				}
			}
		}

		for (int i = 0; i <= sortiert.size() - 1; i++) {
			int a = sortiert.get(i);
			System.out.println(a);
		}

		long endtime = System.currentTimeMillis();
		long time = endtime - starttime;
		System.out.print("Dauer: ");
		System.out.println(time);
	}
}