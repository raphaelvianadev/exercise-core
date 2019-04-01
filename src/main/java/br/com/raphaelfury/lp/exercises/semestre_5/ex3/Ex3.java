package br.com.raphaelfury.lp.exercises.semestre_5.ex3;

import java.util.Comparator;
import java.util.stream.Collectors;

import br.com.raphaelfury.core.panel.PanelBuilder;
import br.com.raphaelfury.lp.exercises.Exercise;
import br.com.raphaelfury.lp.exercises.semestre_5.ex3.game.Game;
import br.com.raphaelfury.lp.exercises.semestre_5.ex3.game.map.GameMap;

public class Ex3 extends Exercise {
	
	private GameMap gameMap = new GameMap();
	private PanelBuilder panel = new PanelBuilder("Ex3");

	public Ex3() {
		super("Ex3", "Lan house", true);
	}
	
	@Override
	public void start() {
		boolean running = true;
		//int index = 0;
		//Scanner scanner = new Scanner(System.in);
		
		while (running) {
			//sendOptions();
			//index = scanner.nextInt();
			switch (sendOptionsPane()) {
			case 1:
				Game game = new Game();
				getGameMap().add(game);
				break;
			case 2:
				getGameMap().remove(Integer.valueOf(panel.input("Digite o código desejado para a remoção", "Remoção", 3)));
				break;
			case 3:
				//log("Código | Jogo | Jogadores | Tempo | Vencedor");
				StringBuilder gameList = new StringBuilder();
				gameList.append("Código | Jogo | Jogadores | Tempo | Vencedor\n\n");
				for(Game games : getGameMap().getGames())
					//log("#" + games.getId() + " | " + games.getGame() + " | " + games.getPlayers() + " | " + formatTime(games.getTime(), TimeFormatMode.INCOMPLETE) + " | " + games.getWinner());
					gameList.append("#" + games.getId() + " | " + games.getGame() + " | " + games.getPlayers() + " | " + formatTime(games.getTime(), TimeFormatMode.INCOMPLETE) + " | " + games.getWinner() + "\n");
				//log("Quantidade de jogos registrados: " + getGameMap().getGames().size());
				gameList.append("\n");
				gameList.append("Quantidade de jogos registrados: " + getGameMap().getGames().size());
				panel.message(gameList.toString(),  "Listagem de jogos", -1);
				break;
			case 4:
				Game gamePlayers = getGameMap().getStream().collect(Collectors.maxBy(Comparator.comparingInt(Game :: getPlayers))).get();
				//log("#" + gamePlayers.getId() + " - " + gamePlayers.getGame() + "(" + gamePlayers.getPlayers() + ")");
				panel.message("#" + gamePlayers.getId() + " - " + gamePlayers.getGame() + "(" + gamePlayers.getPlayers() + ")", "Jogo com mais jogadores", 1);
				break;
			case 5:
				finalize();
				break;
			default:
				break;
			}
		}
	}
	
	public void sendOptions() {
		blankLine();
		log("1. Cadastrar jogo");
		blankLine();
		log("2. Remover jogo");
		blankLine();
		log("3. Listar jogos");
		blankLine();
		log("4. Mostrar o jogo com maior nº de jogadores.");
		blankLine();
		log("5. Finalizar");
		blankLine();
	}
	
	public int sendOptionsPane() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("1. Cadastrar jogo");
		builder.append("\n");
		builder.append("2. Remover jogo");
		builder.append("\n");
		builder.append("3. Listar jogos");
		builder.append("\n");
		builder.append("4. Mostrar o jogo com maior nº de jogadores");
		builder.append("\n");
		builder.append("5. Finalizar");
		builder.append("\n");
		builder.append("\n");
		
		return Integer.valueOf(panel.input(builder.toString(), "Menu", -1));
	}
	
	public enum TimeFormatMode { COMPLETE, INCOMPLETE; }

	public String formatTime(int time, TimeFormatMode format) {
		if(format.equals(TimeFormatMode.COMPLETE)) {
		String min = " minuto", s = " segundo";
		if (time >= 60) {
			Integer minutes = time / 60, seconds = time - minutes * 60;
			String minute = (minutes > 1 ? minutes + min + "s" : minutes + min),
					second = (seconds > 1 ? "e " + seconds + s + "s" : "e " + seconds + s);
			return minute + (seconds != 0 ? " " + second : "");
		}
		return (time > 1 ? time + s + "s" : time + s);
		} else {
			if(time >= 60) {
				int minutes = time / 60, seconds = time - minutes * 60;
				return minutes + "min " + (seconds != 0 ? seconds + "s" : "");
			}
			return (time > 0 ? time + "s" : "");
		}
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

}
