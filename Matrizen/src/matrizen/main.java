package matrizen;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		Matrix i = new Matrix(2,1);
		i.set(0, 0, 5);
		i.set(1, 0, 7);
		
		ArrayList<Integer> hiddenL = new ArrayList<Integer>();
		
		hiddenL.add(2);
		hiddenL.add(4);
		hiddenL.add(3);
		
		Matrix o = new Matrix(2,1);
		
		ANN ann = new ANN(i, hiddenL, o);
		ann.run();
		if (ann.output.get(0, 0) >= 0.5 && ann.output.get(1, 0) < 0.5) {
			// geh nach links
		} else if (ann.output.get(0, 0) < 0.5 && ann.output.get(1, 0) >= 0.5) {
			// geh nach rechts
		}
	}
}
