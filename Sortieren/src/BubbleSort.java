import java.util.ArrayList;

public class BubbleSort {

	public static ArrayList<Integer> getRandomList(int a) {
		ArrayList<Integer> random = new ArrayList<Integer>();
		for (int i = 1; i <= a; i++) {
			random.add((int) (Math.random() * 100) + 1);
		}

		return random;
	}

	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> a) {
		for (int j = 0; j < (a.size() * 2); j++) {
			for (int i = 0; i < a.size() - 1; i++) {
				if (a.get(i) > a.get(i + 1)) {
					int z = a.get(i);
					a.remove(i);
					a.add(z);
				}
			}
		}

		return a;
	}

	public static void main(String[] args) {
		int a = 10;
		ArrayList<Integer> zahlen = getRandomList(a);

		System.out.println(bubbleSort(zahlen));
	}
}
