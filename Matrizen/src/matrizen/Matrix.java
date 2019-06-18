package matrizen;

public class Matrix {
	float[][] data;
	int row;
	int col;

	public Matrix(int row, int col) {
		this.data = new float[row][col];
		this.row = row;
		this.col = col;
	}

	public float get(int r, int c) {
		return this.data[r][c];
	}

	public void set(int r, int c, float v) {
		this.data[r][c] = v;
	}

	public int getRows() {
		return row;
	}

	public int getCols() {
		return col;
	}

	public boolean equals(Matrix b) {
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				if (this.get(i, j) != b.get(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	public void sigmoid() {
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				this.set(i, j, (float) (1 / (Math.exp(-this.get(i, j)) + 1)));
			}
		}
	}

	public void mutate(int p) {
		double prob = 1 - ((2 / 100) * p);

		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {

				if ((Math.random() * 2) - 1 >= prob) {

					this.set(i, j, ((float) (Math.random() * 2) - 1));

				}

			}
		}

	}
}
