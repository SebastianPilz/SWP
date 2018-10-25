// 25.10.2018
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<IBiggerThan> l = new ArrayList<>();
		l.add(new Person("Martin", "Schoepf", 25));
		l.add(new Person("Sebastian", "Pilz", 17));
		
		sort(l);
	}
	
	public static void sort(ArrayList<IBiggerThan> l) {
		for (int i = 0; i < l.size() - 1; i++) {
			if (l.get(i).isBiggerThan(l.get(i + 1))) {
				System.out.println("is bigger");
			} else {
				System.out.println("is smaller");
			}
		}
	}
}
