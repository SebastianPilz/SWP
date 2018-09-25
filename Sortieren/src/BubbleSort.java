import java.util.ArrayList;

public class BubbleSort {

	public static ArrayList<Integer> getRandomList(int a) {
		ArrayList<Integer> random = new ArrayList<Integer>();
		for (int i = 1; i <= a; i++) {
			random.add((int) (Math.random() * 100) + 1);
		}
		return random;
	}

	public static void main(String[] args) {
		int s = 10;
		ArrayList<Integer> zahl = getRandomList(s);

		for (int j = 0; j < s; j++) {
			for (int i = 0; i < s - 1; i++) {
				if (zahl.get(i) > zahl.get(i + 1)) {
					int z = zahl.get(i);
					zahl.remove(i);
					zahl.add(z);
				}
			}
		}
		
		for (int i = 0; i <= zahl.size() - 1; i++) {
			int a = zahl.get(i);
			System.out.println(a);
		}

	}
}
