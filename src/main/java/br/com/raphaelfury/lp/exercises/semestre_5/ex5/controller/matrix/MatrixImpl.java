package br.com.raphaelfury.lp.exercises.semestre_5.ex5.controller.matrix;
public class MatrixImpl {
	
	private int determinant;

	public double calculateMatrixDeterminant(double matrix[][], int order) {
		if (order == 1)
			return (matrix[0][0]);
		if (order == 2)
			return (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]);
		else {
			double[][] matrixHelper = new double[order - 1][order - 1];
			int columnHelper = 0;
			for (int control = 0; control < order; control++) {
				for (int line = 1; line < order; line++) {
					for (int column = 0; column < order; column++)
						if (control != column)
							matrixHelper[line - 1][columnHelper++] = (int) matrix[line][column];
					columnHelper = 0;
				}
				if (matrix[0][control] != 0)
					setDeterminant((int) (Math.pow((-1), control) * matrix[0][control] * calculateMatrixDeterminant(matrixHelper, order - 1)));
			}
		}
		return (getDeterminant());
	}
	
	public int getDeterminant() {
		return determinant;
	}

	public void setDeterminant(int determinant) {
		this.determinant += determinant;
	}

}
