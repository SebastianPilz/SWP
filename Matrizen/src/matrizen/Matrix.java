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
		for (int i = 0; i <= this.getRows() - 1; i++) {
			for (int j = 0; j <= this.getCols() - 1; j++) {
				if (this.get(i, j) != b.get(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void sigmoid() {
		for (int i = 0; i <= this.getRows() - 1; i++) {
			for (int j = 0; j <= this.getCols() - 1; j++) {
				this.set(i, j, (float) (1/(Math.exp(-this.get(i, j))+1)));
			}
		}
	}
}
