// 4.12.2018
public class Main {
	public static void main(String[] args) {
		/**
		BinarySearchTree<Integer> b = new BinarySearchTree<>();

		b.add(10);

		b.add(5);
		b.add(4);
		b.add(7);
		b.add(6);
		b.add(3);

		b.add(13);
		b.add(11);
		b.add(12);
		b.add(15);
		b.add(14);
		b.add(17);
		b.add(16);

		b.remove(5);
		b.search(2);
		**/
		BinarySearchTree<Person> p = new BinarySearchTree<>();
		
		p.add(new Person("Martin", "Schoepf", 25));
		p.add(new Person("Sebastian", "Pilz", 17));
		p.add(new Person("Roshy", "Moon", 55));
		p.add(new Person("Mario", "Bernardi", 60));
		p.add(new Person("Lukas", "Heber", 99));
		p.add(new Person("Alex", "Widerin", 18));
		p.add(new Person("Elias", "Neuner", 8));
	}
}
