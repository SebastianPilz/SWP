// 25.10.2018
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<IBiggerThan> l = new ArrayList<>();
		l.add(new Person("Martin", "Schoepf", 25));
		l.add(new Person("Sebastian", "Pilz", 17));
		l.add(new Person("Roshy", "Moon", 55));
		l.add(new Person("Mario", "Bernardi", 60));
		l.add(new Person("Lukas", "Heber", 99));
		l.add(new Person("Alex", "Widerin", 18));
		l.add(new Person("Elias", "Neuner", 8));
		
		System.out.println(sort(l));
	}
	
	public static ArrayList<IBiggerThan> sort(ArrayList<IBiggerThan> a) {
		/**
		for (int i = 0; i < l.size() - 1; i++) {
			if (l.get(i).isBiggerThan(l.get(i + 1))) {
				System.out.println("is bigger");
			} else {
				System.out.println("is smaller");
			}
		}
		**/
		for (int j = 0; j < (a.size() * 3); j++) {
			for (int i = 0; i < a.size() - 1; i++) {
				if (a.get(i).isBiggerThan(a.get(i + 1))) {
					IBiggerThan z = a.get(i);
					a.remove(i);
					a.add(z);
				}
			}
		}

		return a;
	}
}
