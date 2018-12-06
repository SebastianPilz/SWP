// 27.11.2018
public class BinarySearchTree {
	private Node head;

	public void add(int value) {
		Node n = new Node(value);

		if (head == null) {
			// Head wird gesetzt
			
			head = n;
		} else {
			// Head ist schon gesetzt
			
			Node tmp = head;

			while (tmp.getBigger() != null && n.getValue() > tmp.getValue()
					|| tmp.getSmaller() != null && n.getValue() <= tmp.getValue()) {
				// Finden der letzten Zahl, bzw wo der richtige Platz ist
				
				if (n.getValue() <= tmp.getValue()) {
					tmp.setSmall();
					tmp = tmp.getSmaller();
				} else {
					tmp.setBig();
					tmp = tmp.getBigger();
				}
			}

			if (n.getValue() <= tmp.getValue()) {
				tmp.setSmaller(n);
				tmp.setSmall();
				System.out.printf("Eingesetzt: %d \n" , n.getValue());
			} else {
				tmp.setBigger(n);
				tmp.setBig();
				System.out.printf("Eingesetzt: %d \n" , n.getValue());
			}
		}
	}

	public Node search(Node n, Node pos) {
		if (n.getValue() == pos.getValue()) {
			System.out.println("Gefunden!");
			
			return pos;
		}
		
		if (n.getValue() > pos.getValue()) {
			
			if (pos.getBigger() == null) {
				System.out.println("Nicht gefunden!");
				
				return n;
			}
			
			return search(n, pos.getBigger());
		}
		
		if (n.getValue() < pos.getValue()) {
			
			if (pos.getSmaller() == null) {
				System.out.println("Nicht gefunden!");
				
				return n;
			}
			
			return search(n, pos.getSmaller());
		}
		
		return pos;
	}

	public Node search(int value) {
		Node n = new Node(value);
		
		return search(n, head);
	}
	
	public Node findBiggest(Node n) {
		while (n.getSmall() > 1) {
			n = n.getSmaller();
			System.out.printf("Do sein ma: %d\n", n.getValue());
		}
		
		return n;
	}
	
	public Node findSmallest(Node n) {
		while (n.getBig() > 1) {
			n = n.getBigger();
			System.out.printf("Do sein ma: %d\n", n.getValue());
		}
		
		return n;
	}

	public Node remove(Node n, Node pos) {
		System.out.println("neue runde");

		if (n.getValue() == pos.getValue()) {
			// Zu löschender Wert gefunden
			System.out.println("Da habn man!");
			if (pos.getBig() == 1) {
				// Es gibt nur einen groesseren Wert
				System.out.println("Der hat lei oanen");
				Node tmp = pos.getBigger();
				pos.setBigger(null);
				pos = tmp;
				System.out.println("jawohl1");
				
				return pos;
				
			} else if (pos.getBig() == 0) {
				// Es gibt keinen groesseren Wert
				System.out.println("Der hat koanen");
				if (pos.getSmall() == 0) {
					// Es gibt keinen kleineren Wert
					
					pos = null;
					System.out.println("jawohl2");
					
					return null;
					
				} else if (pos.getSmall() == 1) {
					// Es gibt einen kleineren Wert
					System.out.println("Der hat lei oanen kloanen");
					Node tmp = pos.getSmaller();
					pos.setSmaller(null);
					pos = tmp;
					System.out.println("jawohl3");
					
					return pos;
					
				} else if (pos.getSmall() > 1) {
					// Es gibt mehrere kleinere Werte darunter
					System.out.println("Der hat viele kloane");
					
					Node tmp = pos;
					tmp = pos.getSmaller();
					tmp = findSmallest(tmp);
					// tmp ist der groesste Wert auf der linken, kleineren Seite
					System.out.printf("Da is da greaste: %d\n", tmp.getBigger().getValue());
					pos = tmp.getBigger();
					tmp.setBigger(null);
					System.out.println("Passt hobn ma");
					
					return pos;
				}
			} else if (pos.getBig() > 1) {
				// Es gibt mehrere groessere Werte darunter
				System.out.println("Der hat viele");
				
				Node tmp = pos;
				tmp = tmp.getBigger();
				tmp = findBiggest(tmp);
				// tmp ist der kleinste Wert auf der rechten, groesseren Seite
				
				System.out.printf("Da is da kleinste: %d\n", tmp.getSmaller().getValue());
				pos = tmp.getSmaller();
				tmp.setSmaller(null);
				System.out.println("Passt hobn ma");
				
				
				return pos;
			}
		}
		if (n.getValue() < pos.getValue()) {
			// Zu löschender Wert ist kleiner
			pos.minSmall();
			System.out.println("de zahl is kleiner");
			
			return remove(n, pos.getSmaller());
		}
		if (n.getValue() > pos.getValue()) {
			// Zu löschender Wert ist groesser
			pos.minBig();
			System.out.println("de zahl is groesser");
			
			return remove(n, pos.getBigger());
		}

		return remove(n, pos);
	}

	public Node remove(int value) {
		Node n = new Node(value);
		
		return remove(n, head);
	}
}
