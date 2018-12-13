// 27.11.2018
public class Main {
	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();

		b.add(24);
		
		b.add(15);
		
		b.add(18);
		b.add(17);
		b.add(16);
		b.add(20);
		b.add(19);
		b.add(23);
		b.add(22);
		b.add(21);
		
		b.add(5);
		b.add(4);
		b.add(14);
		b.add(10);
		b.add(9);
		b.add(12);
		
		b.add(30);
		b.add(25);
		b.add(26);
		b.add(27);
		b.add(32);
		b.add(35);
		
		b.remove(15);
		b.search(15);
		//b.show();
	}
}
