package br.com.raphaelfury.core.confirmation;

public class InputConfirmation {
	
	public static boolean isConfirmable(String x) {
		if(x.equalsIgnoreCase("s") || x.equalsIgnoreCase("sim") || x.equalsIgnoreCase("y") || x.equalsIgnoreCase("yes"))
			return true;
		else if(x.equalsIgnoreCase("n") || x.equalsIgnoreCase("nao") || x.equalsIgnoreCase("não") || x.equalsIgnoreCase("no"))
			return false;
		return false;
		
	}

}
