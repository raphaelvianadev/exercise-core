package br.com.raphaelfury.core.formatter;

public class StringFormatters {
	
	public String cpfFormat(String cpf) {
		String firstBlock = cpf.substring(0, 3);
		String secondBlock = cpf.substring(3, 6);
		String thirdBlock = cpf.substring(6, 9);
		String fourthBlock = cpf.substring(9, 11);
		cpf = firstBlock + "." + secondBlock + "." + thirdBlock + "-" + fourthBlock;
		return cpf;
	}

}
