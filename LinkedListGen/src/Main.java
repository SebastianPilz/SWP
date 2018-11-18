// 13.11.2018
public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			ll.add(i);
		}

		ll.add(11);
		ll.add(12);
		ll.remove(1);

		for (int i = 0; i < ll.getSize(); i++) {
			System.out.println(ll.getValue(i));
		}

		System.out.print("Größe: ");
		System.out.println(ll.getSize());
		System.out.println(ll.getValue(2));

		LinkedList<String> ll2 = new LinkedList<>();
		String s = "Ich bin der Manuel";
		ll2.add(s);

		for (int i = 0; i < ll2.getSize(); i++) {
			System.out.println(ll2.getValue(i));
		}
	}

}
