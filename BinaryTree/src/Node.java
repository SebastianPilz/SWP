// 27.11.2018
public class Node {
	private int value;
	private Node smaller;
	private Node bigger;
	private int small;
	private int big;

	public Node(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getSmaller() {
		return smaller;
	}

	public void setSmaller(Node smaller) {
		this.smaller = smaller;
	}

	public Node getBigger() {
		return bigger;
	}

	public void setBigger(Node bigger) {
		this.bigger = bigger;
	}

	public int getSmall() {
		return small;
	}

	public void setSmall() {
		this.small = small + 1;
	}

	public int getBig() {
		return big;
	}

	public void setBig() {
		this.big = big + 1;
	}

}
