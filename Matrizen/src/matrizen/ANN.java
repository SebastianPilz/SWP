package matrizen;

import java.util.ArrayList;

public class ANN {

	Matrix input;
	ArrayList<Matrix> weights;
	ArrayList<Matrix> bios;
	Matrix output;
	int anzHiddenL;

	public ANN(Matrix input, ArrayList<Integer> hiddenL, Matrix output) {

		this.input = input;
		this.output = output;
		this.anzHiddenL = hiddenL.size();

		this.weights.add(getRandomWeights(hiddenL.get(0), input.getRows()));

		if (hiddenL.size() > 2) {
			for (int i = 1; i < hiddenL.size(); i++) {
				this.weights.add(getRandomWeights(hiddenL.get(i), hiddenL.get(i - 1)));
			}
		}
		
		this.weights.add(getRandomWeights(hiddenL.get(hiddenL.size() - 1), output.getRows()));

		for (int i = 0; i < hiddenL.size(); i++) {
			this.bios.add(getRandomBios(hiddenL.get(i)));
		}		
	}

	public Matrix mul(Matrix w, Matrix I, Matrix b) {
		Matrix v = matrizen.mult(w, I);
		v = matrizen.add(v, b);
		v.sigmoid();
		
		return v;
	}

	public Matrix getRandomWeights(int a, int b) {
		Matrix m = new Matrix(a, b);
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				m.set(i, j, ((float) (Math.random() * 300) - 150));
			}
		}

		return m;
	}

	public Matrix getRandomBios(int a) {
		Matrix m = new Matrix(a, 1);
		for (int i = 0; i <= a; i++) {
			m.set(i, 1, ((float) (Math.random() * 300) - 150));
		}

		return m;
	}

}
