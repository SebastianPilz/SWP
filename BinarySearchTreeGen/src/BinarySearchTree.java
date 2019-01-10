// 4.12.2018
public class BinarySearchTree<T extends ICompare> {
	private Node<T> head;

	public Node<T> search(T value) {
		Node<T> n = new Node<T>(value);

		return search(n, head);
	}

	public Node<T> remove(T value) {
		Node<T> n = new Node<T>(value);

		return remove(n, head, head);
	}

	public Node<T> findBiggest(Node<T> n) {
		while (n.getBig() > 1) {
			if (n.getBigger().getBig() == 0) {
				return n;
			}
			n = n.getBigger();
			System.out.printf("Do sein ma: %d\n", n.getValue());

		}

		return n;
	}

	public Node<T> findSmallest(Node<T> n) {
		while (n.getSmall() > 1) {
			if (n.getSmaller().getSmall() == 0) {
				return n;
			}
			n = n.getSmaller();
			System.out.printf("Do sein ma: %d\n", n.getValue());
		}

		return n;
	}

	public Node<T> add(T value) {
		Node<T> n = new Node<T>(value);

		return add(n, head);
	}

	public Node<T> add(Node<T> n, Node<T> pos) {
		if (head == null) {
			// Head wird gesetzt
			head = n;
		} else {
			/*
			 * // Head ist schon gesetzt
			 * 
			 * Node<T> tmp = head;
			 * 
			 * while (tmp.getBigger() != null && n.getValue().isBiggerThan(tmp.getValue())
			 * || tmp.getSmaller() != null && n.getValue().isSmallerEqThan(tmp.getValue()))
			 * { // Finden der letzten Zahl, bzw wo der richtige Platz ist
			 * 
			 * if (n.getValue().isSmallerEqThan(tmp.getValue())) { tmp.setSmall(); tmp =
			 * tmp.getSmaller(); } else { tmp.setBig(); tmp = tmp.getBigger(); } }
			 * 
			 * if (n.getValue().isSmallerEqThan(tmp.getValue())) { tmp.setSmaller(n);
			 * tmp.setSmall(); System.out.printf("Eingesetzt: %d \n", n.getValue()); } else
			 * { tmp.setBigger(n); tmp.setBig(); System.out.printf("Eingesetzt: %d \n",
			 * n.getValue()); }
			 */

			if (n.getValue().isSmallerEqThan(pos.getValue())) {
				if (pos.getSmall() == 0) {
					pos.setSmaller(n);
					System.out.printf("Eingesetzt: %d \n", n.getValue());
					pos.setSmall();
				} else {
					pos.setSmall();

					return add(n, pos.getSmaller());
				}
			} else {
				if (pos.getBig() == 0) {
					pos.setBigger(n);
					System.out.printf("Eingesetzt: %d \n", n.getValue());
					pos.setBig();
				} else {
					pos.setBig();

					return add(n, pos.getBigger());
				}
			}
		}

		return n;
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

	public Node<T> remove(Node<T> n, Node<T> pos, Node<T> parent) {
		System.out.println("neue runde");

		if (n.getValue() == head.getValue()) {
			Node<T> tmp = head;

			if (head.getBigger() == null && head.getSmaller() == null) {
				System.out.println("Der hat nix der Head is aloan");
				head = null;
			}

			if (head.getBigger() != null) {
				tmp = findSmallest(tmp.getBigger());
				System.out.println("Der hat a poa groessere");
				Node<T> tmp1 = tmp;
				if (tmp.getSmaller().getBig() > 1) {
					System.out.println("AY der hat a welche");
					remove(tmp.getSmaller(), tmp.getSmaller(), tmp);
				}
				head = tmp1.getSmaller();

				return null;
			} else {
				tmp = findBiggest(tmp.getSmaller());
				System.out.println("Der hat a poa kleinere");
				Node<T> tmp1 = tmp;
				if (tmp.getBigger().getSmall() > 1) {
					System.out.println("AY der hat a welche");
					remove(tmp.getBigger(), tmp.getBigger(), tmp);
				}
				head = tmp1.getBigger();

				return null;
			}
		}

		if (n.getValue() == pos.getValue()) {
			// Zu löschender Wert gefunden
			System.out.println("Da habn man!");
			if (pos.getBig() == 1) {
				// Es gibt nur einen groesseren Wert
				System.out.println("Der hat lei oanen");

				if (pos.getValue().isSmallerThan(parent.getValue())) {
					parent.setSmaller(parent.getSmaller().getBigger());
				}

				if (pos.getValue().isBiggerThan(parent.getValue())) {
					parent.setBigger(parent.getBigger().getBigger());
				}

				System.out.println("jawohl1");

				return pos;

			} else if (pos.getBigger() == null) {
				// Es gibt keinen groesseren Wert
				System.out.println("Der hat koanen");
				if (pos.getSmaller() == null) {
					// Es gibt keinen kleineren Wert

					if (pos.getValue().isSmallerThan(parent.getValue())) {
						parent.setSmaller(null);
					}

					if (pos.getValue().isBiggerThan(parent.getValue())) {
						parent.setBigger(null);
					}

					System.out.println("jawohl2");

					return null;

				} else if (pos.getSmall() == 1) {
					// Es gibt einen kleineren Wert
					System.out.println("Der hat lei oanen kloanen");

					if (pos.getValue().isSmallerThan(parent.getValue())) {
						parent.setSmaller(parent.getSmaller().getSmaller());
					}

					if (pos.getValue().isBiggerThan(parent.getValue())) {
						parent.setBigger(parent.getBigger().getSmaller());
					}

					System.out.println("jawohl3");

					return pos;

				} else if (pos.getSmall() > 1) {
					// Es gibt mehrere kleinere Werte darunter
					System.out.println("Der hat viele kloane");

					Node<T> tmp = pos;
					if (tmp.getSmaller().getBigger() != null) {

						tmp = findBiggest(tmp.getSmaller());
						// tmp ist der Wert direkt vor dem groessten, also der parent
						System.out.printf("Da is da greaste: %d\n", tmp.getBigger().getValue());
						// Fall wenn die Node noch weitere kleinere Werte darunter hat
						if (tmp.getBigger().getSmall() > 1) {
							remove(tmp.getBigger().getSmaller(), tmp.getBigger(), tmp);
						}
						// Loeschen der Node
						if (pos.getValue().isSmallerThan(parent.getValue())) {
							parent.setSmaller(tmp.getBigger());
						}

						if (pos.getValue().isBiggerThan(parent.getValue())) {
							parent.setBigger(tmp.getBigger());
						}

						System.out.println("Passt hobn ma");
					} else {
						parent.setSmaller(parent.getSmaller().getSmaller());
					}

					return pos;
				}
			} else if (pos.getBig() > 1) {
				// Es gibt mehrere groessere Werte darunter
				System.out.println("Der hat viele");

				Node<T> tmp = pos;
				if (tmp.getBigger().getSmaller() != null) {
					tmp = findSmallest(tmp.getBigger());
					System.out.printf("Da is da kleinste: %d\n", tmp.getSmaller().getValue());
					// tmp ist der Wert direkt vor dem kleinsten Wert, also der parent
					// Fall wenn die Node noch weitere groessere Werte darunter hat
					if (tmp.getSmaller().getBig() > 1) {
						remove(tmp.getSmaller().getBigger(), tmp.getSmaller(), tmp);
					}
					// Loeschen der Node
					if (pos.getValue().isSmallerThan(parent.getValue())) {
						parent.setSmaller(tmp.getSmaller());
					}

					if (pos.getValue().isBiggerThan(parent.getValue())) {
						parent.setBigger(tmp.getSmaller());
					}

					System.out.println("Passt hobn ma");
				} else {
					// Wenn es mehrere groessere Werte unter tmp gibt aber nie kleinere, also der
					// kleinste Wert der direkt darunter ist

					// Loeschen der Node

					parent.setSmaller(parent.getSmaller().getBigger());

					System.out.println("Passt hobn ma");
				}

				return pos;
			}
		}
		if (n.getValue().isSmallerThan(pos.getValue())) {
			// Zu löschender Wert ist kleiner
			pos.minSmall();
			System.out.println("de zahl is kleiner");

			return remove(n, pos.getSmaller(), pos);
		}
		if (n.getValue().isBiggerThan(pos.getValue())) {
			// Zu löschender Wert ist groesser
			pos.minBig();
			System.out.println("de zahl is groesser");

			return remove(n, pos.getBigger(), pos);
		}

		return remove(n, pos, pos);
	}
}
