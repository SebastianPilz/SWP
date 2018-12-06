// 4.12.2018
public class BinarySearchTree<T> {
	private Node<T> head;

	public void add(T value) {
		Node<T> n = new Node<T>(value);

		if (head == null) {
			// Head wird gesetzt
			
			head = n;
		} else {
			// Head ist schon gesetzt
			
			Node<T> tmp = head;

			while (tmp.getBigger() != null && n.getValue().isBiggerThan(tmp.getValue())
					|| tmp.getSmaller() != null && n.getValue().isSmallerEqThan(tmp.getValue())) {
				// Finden der letzten Zahl, bzw wo der richtige Platz ist
				
				if (n.getValue().isSmallerEqThan(tmp.getValue())) {
					tmp.setSmall();
					tmp = tmp.getSmaller();
				} else {
					tmp.setBig();
					tmp = tmp.getBigger();
				}
			}

			if (n.getValue().isSmallerEqThan(tmp.getValue())) {
				tmp.setSmaller(n);
				tmp.setSmall();
			} else {
				tmp.setBigger(n);
				tmp.setBig();
			}
		}
	}

	public Node<T> search(Node<T> n, Node<T> pos) {

		if (n.getValue() == pos.getValue()) {
			System.out.println("Gefunden!");
			return pos;
		}
		
		if (n.getValue().isBiggerThan(pos.getValue())) {
			
			if (pos.getBigger() == null) {
				System.out.println("Nicht gefunden!");
				
				return n;
			}
			
			return search(n, pos.getBigger());
		}
		
		if (n.getValue().isSmallerThan(pos.getValue())) {
			
			if (pos.getSmaller() == null) {
				System.out.println("Nicht gefunden!");
				
				return n;
			}
			
			return search(n, pos.getSmaller());
		}
		
		return pos;
	}

	public Node<T> search(T value) {
		Node<T> n = new Node<T>(value);
		
		return search(n, head);
	}

	public Node<T> remove(Node<T> n, Node<T> pos) {
		System.out.println("neue runde");

		if (n.getValue() == pos.getValue()) {
			// Zu löschender Wert gefunden
			
			if (pos.getBig() == 1) {
				// Es gibt nur einen groesseren Wert
				
				pos = pos.getBigger();
				pos.setBigger(null);
				System.out.println("jawohl1");
				
				return pos;
			} else if (pos.getBig() == 0) {
				// Es gibt keinen groesseren Wert
				
				if (pos.getSmall() == 0) {
					// Es gibt keinen kleineren Wert
					
					pos = null;
					System.out.println("jawohl2");
					
					return null;
				} else if (pos.getSmall() == 1) {
					// Es gibt einen kleineren Wert
					
					pos = pos.getSmaller();
					pos.setSmaller(null);
					System.out.println("jawohl3");
					
					return pos;
				} else if (pos.getSmall() > 1) {
					// Es gibt mehrere kleinere Werte darunter
					
					Node<T> tmp = pos;
					tmp = pos.getSmaller();
					
					while (pos.getBig() >= 1) {
						tmp = tmp.getBigger();
					}
					pos = tmp.getBigger();
					tmp.setBigger(null);
					
					return pos;
				}
			} else if (pos.getBig() > 1) {
				// Es gibt mehrere groessere Werte darunter
				
				Node<T> tmp = pos;
				tmp = tmp.getBigger();
				
				while (tmp.getSmall() >= 1) {
					tmp = tmp.getSmaller();
				}
				pos = tmp.getSmaller();
				tmp.setSmaller(null);
				
				return pos;
			}
		}
		if (n.getValue().isSmallerThan(pos.getValue())) {
			// Zu löschender Wert ist kleiner
			
			System.out.println("de zahl is kleiner");
			
			return remove(n, pos.getSmaller());
		}
		if (n.getValue().isBiggerThan(pos.getValue())) {
			// Zu löschender Wert ist groesser
			
			System.out.println("de zahl is groesser");
			
			return remove(n, pos.getBigger());
		}

		return remove(n, pos);
	}

	public Node<T> remove(T value) {
		Node<T> n = new Node<T>(value);
		
		return remove(n, head);
	}
}
