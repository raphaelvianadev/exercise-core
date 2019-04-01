package br.com.raphaelfury.lp.exercises.semestre_5.ex3.game;

import br.com.raphaelfury.core.panel.PanelBuilder;

public class Game {

	private int id, players, time;
	private String game, winner;

	public Game() {
		//Logger logger = new Logger();
		//Scanner scanner = new Scanner(System.in);
		
		int id = Integer.valueOf(new PanelBuilder("REGISTRO").input("Insira o código do jogo", "Código", 2));
		setId(id);
		//logger.log("Digite o código do jogo");
		//setId(scanner.nextInt());
		
		String name = new PanelBuilder("REGISTRO").input("Insira o nome do jogo", "Nome", 2);
		setGame(name);
		//logger.log("Digite o nome do jogo");
		//setGame(scanner.next());
		
		
		int players = Integer.valueOf(new PanelBuilder("REGISTRO").input("Insira a quantidade de jogadores", "Jogadores", 2));
		setPlayers(players);
		//logger.log("Digite a quantidade de jogadores");
		//setPlayers(scanner.nextInt());
		
		
		int time = Integer.valueOf(new PanelBuilder("REGISTRO").input("Insira o tempo de jogo", "Tempo", 2));
		setTime(time);
		//logger.log("Digite o tempo de jogo");
		//setTime(scanner.nextInt());
		
		
		String winner = new PanelBuilder("REGISTRO").input("Insira o nome do vencedor", "Vencedor", 2);
		setWinner(winner);
		//logger.log("Digite o usuário do vencedor");
		//setWinner(scanner.next());
	}
	
	/*
	 * public Game() {
		Logger logger = new Logger();
		Scanner scanner = new Scanner(System.in);
		
		logger.log("Digite o código do jogo");
		setId(scanner.nextInt());
		
		logger.log("Digite o nome do jogo");
		setGame(scanner.next());
		
		logger.log("Digite a quantidade de jogadores");
		setPlayers(scanner.nextInt());
		
		logger.log("Digite o tempo de jogo");
		setTime(scanner.nextInt());
		
		logger.log("Digite o usuário do vencedor");
		setWinner(scanner.next());
	}
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

}
