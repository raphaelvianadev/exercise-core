package br.com.raphaelfury.lp.exercises.semestre_5.ex4.controller.type;

import java.util.Arrays;
import java.util.List;

public enum GroupTypes {
	
	EFETIVO("Efetivo", Arrays.asList("e", "efe")), 
	SUBSTITUTO("Substituto", Arrays.asList("s", "sub")), 
	TEC_ADM("Tec_adm", Arrays.asList("tec", "tadm", "tecadm"));

	private String name;
	private List<String> aliases;
	
	private GroupTypes(String name, List<String> aliases) {
		this.setName(name);
		this.setAliases(aliases);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}
}
