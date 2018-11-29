// 27.11.2018
public class BinaryTree {
	private Node head;
	
	
	public void add(int value) {
		Node n = new Node(value);

		if (head == null) {
			head = n;
		} else {
			Node tmp = head;

			while (tmp.getBigger() != null && n.getValue() > tmp.getValue() || tmp.getSmaller() != null && n.getValue() <= tmp.getValue()) {
				if (n.getValue() <= tmp.getValue()) {
					tmp = tmp.getSmaller();
				} else {
					tmp = tmp.getBigger();
				}
			}

			if (n.getValue() <= tmp.getValue()) {
				tmp.setSmaller(n);
				tmp.setSmall();
			} else {
				tmp.setBigger(n);
				tmp.setBig();
			}
		}
	}
	
	public Node search(int value) {
		Node tmp = head;
		if (value == tmp.getValue()) {
			return tmp;
		}
		if (value < tmp.getValue()) {
			if (value == tmp.getSmaller().getValue()) {
				return tmp;
			}
		}
		return tmp;
		
		
	}
	
	public BinaryTree remove(Node n, Node pos) {
		System.out.println("remove");
		if (n.getValue() == pos.getValue()) {
			if (pos.getBig() == 1) {
				pos = pos.getBigger();
				pos.setSmaller(pos.getSmaller());
				
			} else if (pos.getBig() == 0) {
				if (pos.getSmall() == 0) {
					pos = null;
				} else if (pos.getSmall() == 1) {
					pos = pos.getSmaller();
					pos.setSmaller(pos.getSmaller());
				}
			}
		} else if (n.getValue() < pos.getValue()) {
			return remove(n, pos.getSmaller());
		} else if (n.getValue() > pos.getValue()) {
			return remove(n, pos.getBigger());
		}
		
		return remove(n, pos);
	}
	
	public BinaryTree remove(int value) {
		Node n = new Node(value);
		return remove(n, head);
	}
}
