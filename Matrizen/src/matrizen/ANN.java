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
		this.bios.add(getEmptyBios(output.getRows()));
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
				m.set(i, j, ((float) (Math.random() * 2) - 1));
			}
		}

		return m;
	}

	public Matrix getRandomBios(int a) {
		Matrix m = new Matrix(a, 1);
		for (int i = 0; i <= a; i++) {
			m.set(i, 1, ((float) (Math.random() * 2) - 1));
		}

		return m;
	}
	
	public Matrix getEmptyBios(int a) {
		Matrix m = new Matrix(a, 1);

		return m;
	}
	
	public ArrayList<Matrix> getConfig() {
		ArrayList<Matrix> c = new ArrayList<Matrix>();
		
		for (int i = 0; i < this.weights.size(); i++) {
			c.add(this.weights.get(i));
		}
		for (int i = 0; i < this.bios.size(); i++) {
			c.add(this.bios.get(i));
		}
		
		return c;
	}
	
	public void config(ArrayList<Matrix> c) {
		for (int i = 0; i <= (c.size()/2) + 0.5; i++) {
			this.weights.add(c.get(i));
			
		}
		for(int j = (int) ((c.size()/2) + 0.5); j < c.size(); j++) {
			this.bios.add(c.get(j));
		}
	}
	
	public void setInput(Matrix i) {
		this.input = i;
	}
	
	public void crossover(ArrayList<Matrix> c2) {
		ArrayList<Matrix> c1 = this.getConfig();
		ArrayList<Matrix> c = new ArrayList<Matrix>();
		
		for (int i = 0; i <= (c1.size()/2) + 0.5; i++) {
			c.add(c1.get(i));
		}
		for(int i = (int) ((c2.size()/2) + 0.5); i < c.size(); i++) {
			c.add(c2.get(i));
		}
		
	}
	
	public void run() {
		ANN ann = this;
		
		Matrix m1 = new Matrix(ann.bios.get(0).getRows(), 1);
		m1 = mul(ann.weights.get(0), ann.input, ann.bios.get(0));
		
		for (int i = 1; i <= ann.bios.size() - 2; i++) {
			m1 = mul(ann.weights.get(i), m1, ann.bios.get(i));
		}
		
		m1 = mul(ann.weights.get(ann.weights.size() - 1), m1, ann.bios.get(ann.bios.size() - 1));
	}

}
