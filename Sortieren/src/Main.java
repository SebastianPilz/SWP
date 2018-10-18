import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Person> l = new ArrayList<>();
		l.add(new Person("Martin", "Hxber", 18));
		l.add(new Person("Sepp", "Heber", 77));

		if (l.get(1).isBiggerThan(l.get(0))) {
			System.out.println("is bigger");
		}	else {
			System.out.println("is smaller");
		}
		
		if (l.get(1).isSmallerThan(l.get(0))) {
			System.out.println("is smaller");
		}	else {
			System.out.println("is bigger");
		}

		/**
		 * if (l.get(0) > l.get(1)) { System.out.println("is bigger"); }
		 **/
	}
}
