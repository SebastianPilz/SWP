
import java.util.ArrayList;

public class Main {

	public static ArrayList<Person> bubbleSort(ArrayList<Person> a) {
		for (int j = 0; j < (a.size() * 3); j++) {
			for (int i = 0; i < a.size() - 1; i++) {
				if (a.get(i).isBiggerThan(a.get(i + 1))) {
					Person z = a.get(i);
					a.remove(i);
					a.add(z);
				}
			}
		}

		return a;
	}

	public static void main(String[] args) {

		ArrayList<Person> l = new ArrayList<>();
		l.add(new Person("Martin", "Schoepf", 25));
		// Person 0
		l.add(new Person("Sebastian", "Pilz", 17));
		// Person 1

		if (l.get(0).isBiggerThan(l.get(1))) {
			System.out.println("is bigger");
		} else {
			System.out.println("is smaller");
		}

		if (l.get(0).isSmallerThan(l.get(1))) {
			System.out.println("is smaller");
		} else {
			System.out.println("is bigger");
		}

		l.add(new Person("Roshy", "Moon", 55));
		l.add(new Person("Mario", "Bernardi", 60));
		l.add(new Person("Lukas", "Heber", 99));
		l.add(new Person("Alex", "Widerin", 18));
		l.add(new Person("Elias", "Neuner", 8));

		System.out.println(bubbleSort(l));

	}
}
