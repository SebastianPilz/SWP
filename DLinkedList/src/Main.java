
public class Main {

	public static void main(String[] args) {
		DLinkedList<Integer> list = new DLinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.remove(7);
		for (int i = 0; i < list.getSize(); i++) {
			System.out.printf("%d ", list.getValue(i));
		}
		System.out.println();
		System.out.println(list.getValue(8));

	}

}
