
public class Person {

	private String firstName;
	private String lastName;
	private int age;

	public Person(String firstName, String lastName, int age) {
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
	
	

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + "]";
	}

	public boolean isBiggerThan(Person p) {

		String namep1 = this.lastName;
		String namep2 = p.lastName;
		namep1.toLowerCase();
		namep2.toLowerCase();
		int shortest = 0;

		if (namep1.length() <= namep2.length()) {
			shortest = namep1.length();
		} else {
			shortest = namep2.length();
		}

		for (int i = 0; i < shortest; i++) {
			char charp1 = namep1.charAt(i);
			char charp2 = namep2.charAt(i);

			if (charp1 > charp2) {
				return true;
			} else if (charp1 < charp2) {
				return false;
			}
		}
		if (namep1.length() < namep2.length()) {
			return false;
		} else
			return true;

	}

	public boolean isSmallerThan(Person p) {

		String namep1 = this.lastName;
		String namep2 = p.lastName;
		namep1.toLowerCase();
		namep2.toLowerCase();
		int shortest = 0;

		if (namep1.length() <= namep2.length()) {
			shortest = namep1.length();
		} else {
			shortest = namep2.length();
		}

		for (int i = 0; i < shortest; i++) {
			char charp1 = namep1.charAt(i);
			char charp2 = namep2.charAt(i);

			if (charp1 < charp2) {
				return true;
			} else if (charp1 > charp2) {
				return false;
			}
		}
		if (namep1.length() < namep2.length()) {
			return false;
		} else
			return true;
	}
}
