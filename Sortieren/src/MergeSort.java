import java.util.ArrayList;

public class MergeSort {
	
	public static ArrayList<Integer> getRandomList(int a) {
		ArrayList<Integer> random = new ArrayList<Integer>();
		for (int i = 1; i <= a; i++) {
			random.add((int) (Math.random() * 100) + 1);
		}
		
		return random;
	}
	
	public static void main(String[] args) {
		
	}
}
