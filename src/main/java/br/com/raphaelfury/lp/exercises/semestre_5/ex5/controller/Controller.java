package br.com.raphaelfury.lp.exercises.semestre_5.ex5.controller;

import java.util.Scanner;

import br.com.raphaelfury.core.panel.PanelBuilder;
import br.com.raphaelfury.lp.exercises.semestre_5.ex5.controller.matrix.MatrixImpl;

public class Controller {
	
	public void init() {
		MatrixImpl matrixImpl = new MatrixImpl();
		Scanner scanner = new Scanner(System.in);
		int order = Integer.valueOf(new PanelBuilder("Determinante").input("Informe a dimensão da matriz (X x Y)", "Definir matriz", 1));
		double matrix[][] = new double[order][order];
		for (int i = 0; i < matrix.length; i++) 
			for (int c = 0; c < matrix[i].length; c++) 
				matrix[i][c] = Integer.valueOf(new PanelBuilder("Determinante").input("Informe o " + (c + 1) + "º valor da " + (i + 1) + "ª linha: ", "Inserir valores", 1));
		
		scanner.close();
		new PanelBuilder("Determinante").message("Determinante (Δ): " + matrixImpl.calculateMatrixDeterminant(matrix, matrix.length), "Resultado", 3);
	}
	
}
