package matrizen;

public class matrizen {
	
	
	public static Matrix add(Matrix fir, Matrix sec) {
		Matrix value = new Matrix(1, 1);
		
		if (fir.getRows() == sec.getRows() && fir.getCols() == sec.getCols()) {
			Matrix v = new Matrix(fir.getRows(), fir.getCols());
			for (int i = 0; i < fir.getRows(); i++) {
				for (int j = 0; j < fir.getCols(); j++) {
					v.set(i, j, fir.get(i, j) + sec.get(i, j));
				}
			}
			return v;
		}
		
		return value;
	}
	
	public static Matrix mult(Matrix fir, Matrix sec) {

		Matrix value = new Matrix(1, 1);

		if (fir.getRows() == 1 && fir.getRows() == 1 && sec.getRows() == 1 && sec.getCols() == 1) {
			// Skalar * Skalar
			Matrix v = new Matrix(0, 0);
			v.set(0, 0, fir.get(0, 0) * sec.get(0, 0));
			return v;
		}

		if (fir.getRows() == 1 && fir.getRows() == 1 && sec.getRows() != 1 && sec.getCols() != 1) {
			// 1ter = Skalar, 2ter = Vektor oder Matrix

			if (sec.getRows() != 1 && sec.getCols() == 1) {
				// 2te = senkrechter Vektor

				Matrix v = new Matrix(sec.getRows(), 1);
				for (int i = 0; i < sec.getRows(); i++) {
					v.set(i, 0, fir.get(0, 0) * sec.get(i, 0));
				}
				return v;
			}

			if (sec.getRows() == 1 && sec.getCols() != 1) {
				// 2te = waagrechter Vektor

				Matrix v = new Matrix(1, sec.getCols());
				for (int i = 0; i < sec.getCols(); i++) {
					v.set(0, i, fir.get(0, 0) * sec.get(0, i));
				}
				return v;
			}

			if (sec.getRows() != 1 && sec.getCols() != 1) {
				// 2te = Matrix

				Matrix v = new Matrix(sec.getRows(), sec.getCols());
				for (int i = 0; i < sec.getRows(); i++) {
					for (int j = 0; j < sec.getCols(); j++) {
						v.set(i, j, fir.get(0, 0) * sec.get(i, j));
					}
				}
				return v;
			}
		}

		if (sec.getRows() == 1 && sec.getRows() == 1 && fir.getRows() != 1 && fir.getCols() != 1) {
			// 1ter = Vektor oder Matrix, 2ter = Skalar

			if (fir.getRows() != 1 && fir.getCols() == 1) {
				// senkrechter Vektor

				Matrix v = new Matrix(fir.getRows(), 1);
				for (int i = 0; i < fir.getRows(); i++) {
					v.set(i, 0, sec.get(0, 0) * fir.get(i, 0));
				}
				return v;
			}

			if (fir.getRows() == 1 && fir.getCols() != 1) {
				// waagrechter Vektor

				Matrix v = new Matrix(1, fir.getCols());
				for (int i = 0; i < fir.getCols(); i++) {
					v.set(0, i, sec.get(0, 0) * fir.get(0, i));
				}
				return v;
			}

			if (fir.getRows() != 1 && fir.getCols() != 1) {
				// Matrix

				Matrix v = new Matrix(fir.getRows(), fir.getCols());
				for (int i = 0; i < fir.getRows(); i++) {
					for (int j = 0; j < fir.getCols(); j++) {
						v.set(i, j, sec.get(0, 0) * fir.get(i, j));
					}
				}
				return v;
			}
		}

		if (fir.getRows() != 1 && fir.getRows() != 1 && sec.getRows() != 1 && sec.getCols() != 1) {
			// 1ter = Vektor oder Matrix, 2ter = Vektor oder Matrix

			// ----------

			if (fir.getRows() != 1 && fir.getCols() == 1) {
				// 1te = senkrechter Vektor

				if (sec.getRows() != 1 && sec.getCols() == 1) {
					// 1te = senkrechter Vektor, 2te = senkrechter Vektor

					Matrix v = new Matrix(fir.getRows(), 1);
					for (int i = 0; i < fir.getRows(); i++) {
						v.set(i, 0, fir.get(i, 0) * sec.get(i, 0));
					}
					return v;
				}

				if (sec.getRows() == 1 && sec.getCols() != 1) {
					// 1te = senkrechter Vektor, 2te = waagrechter Vektor

					Matrix v = new Matrix(1, 1);
					int w = 0;

					for (int i = 0; i < sec.getCols(); i++) {

						w += sec.get(0, i) * fir.get(i, 0);

					}
					v.set(0, 0, w);
					w = 0;
					return v;

				}

				if (sec.getRows() != 1 && sec.getCols() != 1) {
					// 1te = senkrechter Vektor, 2te = Matrix

					Matrix v = new Matrix(fir.getRows(), 1);
					int w = 0;
					for (int i = 0; i < sec.getRows(); i++) {
						for (int j = 0; i < sec.getCols(); i++) {
							w += sec.get(i, j) * fir.get(i, 0);
						}
						v.set(i, 0, w);
						w = 0;
					}
					return v;
				}
			}

			// ----------

			if (fir.getRows() == 1 && fir.getCols() != 1) {
				// 1te = waagrechter Vektor

				if (sec.getRows() != 1 && sec.getCols() == 1) {
					// 1te = waagrechter Vektor, 2te = senkrechter Vektor

					Matrix v = new Matrix(1, 1);
					int w = 0;

					for (int i = 0; i < fir.getCols(); i++) {

						w += fir.get(0, i) * sec.get(i, 0);

					}
					v.set(0, 0, w);
					w = 0;
					return v;

				}

				if (sec.getRows() == 1 && sec.getCols() != 1) {
					// 1te = waagrechter Vektor, 2te = waagrechter Vektor

					Matrix v = new Matrix(1, fir.getCols());
					for (int i = 0; i < fir.getCols(); i++) {
						v.set(0, i, fir.get(0, i) * sec.get(0, i));
					}
					return v;
				}

				if (sec.getRows() != 1 && sec.getCols() != 1) {
					// 1te = waagrechter Vektor, 2te = Matrix

					Matrix v = new Matrix(1, sec.getCols());
					int w = 0;

					for (int a = 0; a < sec.getCols(); a++) {

						for (int j = 0; j < fir.getCols(); j++) {

							w += fir.get(0, j) * sec.get(j, a);

						}
						v.set(0, a, w);
						w = 0;
					}
					return v;
				}
			}

			// ----------

			if (fir.getRows() != 1 && fir.getCols() != 1) {
				// 1te = Matrix

				if (sec.getRows() != 1 && sec.getCols() == 1) {
					// 1te = Matrix, 2te = senkrechter Vektor

					Matrix v = new Matrix(fir.getRows(), 1);
					int w = 0;
					for (int i = 0; i < fir.getRows(); i++) {

						for (int j = 0; j < fir.getCols(); j++) {

							w += fir.get(i, j) * sec.get(j, 0);

						}
						v.set(i, 0, w);
						w = 0;
					}
					return v;
				}

				if (sec.getRows() == 1 && sec.getCols() != 1) {
					// 1te = Matrix, 2te = waagrechter Vektor

					Matrix v = new Matrix(1, fir.getCols());
					int w = 0;

					for (int a = 0; a < fir.getCols(); a++) {

						for (int j = 0; j < sec.getCols(); j++) {

							w += sec.get(0, j) * fir.get(j, a);

						}
						v.set(0, a, w);
						w = 0;
					}
					return v;
				}

				if (sec.getRows() != 1 && sec.getCols() != 1) {
					// 1te = Matrix, 2te = Matrix

					if (fir.getCols() == sec.getRows()) {
						// 1te Matrix ist "waagrecht" 2te "senkrecht"
						Matrix v = new Matrix(fir.getRows(), sec.getCols());
						int w = 0;
						for (int i = 0; i < fir.getRows(); i++) {

							for (int a = 0; a < sec.getCols(); a++) {

								for (int j = 0; j < fir.getCols(); j++) {

									w += fir.get(i, j) * sec.get(j, a);

								}
								v.set(i, a, w);
								w = 0;
							}
						}
						return v;
					}

					if (fir.getRows() == sec.getCols()) {
						// 1te Matrix ist "senkrecht" 2te "waagrecht"
						Matrix v = new Matrix(sec.getRows(), fir.getCols());
						int w = 0;
						for (int i = 0; i < sec.getRows(); i++) {

							for (int a = 0; a < fir.getCols(); a++) {

								for (int j = 0; j < sec.getCols(); j++) {

									w += sec.get(i, j) * fir.get(j, a);

								}
								v.set(i, a, w);
								w = 0;
							}
						}
						return v;
					}
				}
			}

		}

		return value;
	}
}
