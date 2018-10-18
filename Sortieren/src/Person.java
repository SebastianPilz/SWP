
public class Person {

	private String lastName;
	private String firstName;
	private int age;

	public Person(String lastName, String firstName, int age) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBiggerThan(Person p) {

		String namep1 = this.lastName;
		String namep2 = p.lastName;
		int shortest = 0;
		boolean b = false;

		if (namep1.length() <= namep2.length()) {
			shortest = namep1.length();
		} else {
			shortest = namep2.length();
		}

		for (int i = 0; i < shortest; i++) {
			char charp1 = namep1.charAt(i);
			char charp2 = namep2.charAt(i);

			if (charp1 == charp2) {
				i++;
			}
			if (charp1 > charp2) {
				b = true;
				i = shortest;
			} else if (charp1 < charp2) {
				b = false;
				i = shortest;
			}
		}

		return b;
	}

	public boolean isSmallerThan(Person p) {

		String e = this.lastName;
		char a = e.charAt(0);

		String d = p.lastName;
		char c = d.charAt(0);

		if (a < c) {
			return true;
		} else {
			return false;
		}
	}
}
