// 6.11.2018
public class LinkedList {

	private Node head = null;

	public void add(int value) {
		Node n = new Node(value);

		// if List is empty point to first element
		if (head == null) {
			head = n;
		} else {
			Node tmp = head;
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			tmp.setNext(n);
		}
	}

	public int getValue(int index) {
		Node tmp = head;

		for (int i = 0; i < index; i++) {
			if (tmp.getNext() == null) {
				throw new IndexOutOfBoundsException();
			} else {
				tmp = tmp.getNext();
			}
		}

		return tmp.getValue();
	}

	public int getSize() {
		Node tmp = head;

		int i = 1;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			i++;
		}

		return i;
	}

	public void remove(int index) {
		Node tmp = head;
		
		if (index == 0) {
			head = tmp.getNext();
		} else {
			for (int i = 0; i < index - 1; i++) {
				if (tmp.getNext() == null) {
					tmp.setNext(null);
				}
				tmp = tmp.getNext();
			}
			tmp.setNext(tmp.getNext().getNext());
		}
	}
}
