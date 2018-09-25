
public class CallTypes {

	public int modifyPrimitive(int a) {
		a = 4;
		return a;
	}

	public void mofifyObject(String s) {
		s = "Salut";
	}

	public void modifyPerson(Person p) {
		p.name = "Joseph";
		p.alter = 20;
	}

	public static void main(String[] args) {
		int a = 0;
		String s = "Bonjour";
		Person p = new Person("Seb", 13);

		CallTypes c = new CallTypes();

		a = c.modifyPrimitive(a);
		c.mofifyObject(s);
		c.modifyPerson(p);

		System.out.println(a);
		System.out.println(s);
		System.out.println(p);
	}
}
