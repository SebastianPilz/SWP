
public class Person {

	public String name;
	public int alter;

	public Person(String name, int alter) {
		super();
		this.name = name;
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "Person [Name = " + name + ", Alter = " + alter + "]";
	}

}
