
public class Palindrom {

	public static boolean proofPali(String s) {
		boolean b = false;
		String a = "";
		
		for (int i = 0; i <= s.length(); i++) {
			a = s.substring(s.length() - i, s.length() - i);
		}
		if (s == a) {
			b = true;
		}
		return b;
	}

	public static boolean isPalindrom(String s) {

		if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		if (s.charAt(0) != s.charAt(s.length() - 1)) {
			return false;
		}
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return isPalindrom(s.substring(1, s.length() - 1));
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "Otto";
		// System.out.println(proofPali(s));
		System.out.println(isPalindrom(s.toLowerCase()));
	}
}