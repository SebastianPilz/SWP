
public class Main {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
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
	}

}
