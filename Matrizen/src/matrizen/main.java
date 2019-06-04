package matrizen;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		Matrix input = new Matrix(2,1);
		
		ArrayList<Integer> hiddenL = new ArrayList<Integer>();
		
		hiddenL.add(3);
		hiddenL.add(9);
		hiddenL.add(6);
		
		Matrix output = new Matrix(2,1);
		
		ANN ann = new ANN(input, hiddenL, output);
		ann.run();
	}
}
