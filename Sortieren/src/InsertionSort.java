
public class InsertionSort {
	
	public static void Insertion_Sort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int h = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > h) {
				A[j + 1] = A[j];
				j = j - 1;
			}
			A[j + 1] = h;
		}
	}

	public static void main(String[] args) {
		int[] A = {6, 4, 2, 8, 3, 7, 5, 1};
		Insertion_Sort(A);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
		
	}
}
