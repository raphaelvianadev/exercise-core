package br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller;

import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.controller.ServerType;

public class Server {

	private String name, workStation;
	private int regCode;
	private double remuneration;
	private ServerType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkStation() {
		return workStation;
	}

	public void setWorkStation(String workStation) {
		this.workStation = workStation;
	}

	public int getRegCode() {
		return regCode;
	}

	public void setRegCode(int regCode) {
		this.regCode = regCode;
	}

	public double getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(double remuneration) {
		this.remuneration = remuneration;
	}

	public ServerType getType() {
		return type;
	}

	public void setType(ServerType type) {
		this.type = type;
	}
	
	public void list() {}

}
