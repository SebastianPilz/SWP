// 4.12.2018
public class Node<T> implements ICompare<Node<T>> {
	private T value;
	private Node<T> smaller;
	private Node<T> bigger;
	private int small;
	private int big;

	public Node(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getSmaller() {
		return smaller;
	}

	public void setSmaller(Node<T> smaller) {
		this.smaller = smaller;
	}

	public Node<T> getBigger() {
		return bigger;
	}

	public void setBigger(Node<T> bigger) {
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

	public boolean isBiggerThan(Node<T> n) {
		return this.isBiggerThan(n);
	}

	public boolean isSmallerThan(Node<T> n) {
		return this.isSmallerThan(n);
	}

	public boolean isBiggerEqThan(Node<T> n) {
		return this.isBiggerEqThan(n);
	}

	public boolean isSmallerEqThan(Node<T> n) {
		return this.isSmallerEqThan(n);
	}
}
