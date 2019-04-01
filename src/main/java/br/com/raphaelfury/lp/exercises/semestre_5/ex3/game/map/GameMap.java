package br.com.raphaelfury.lp.exercises.semestre_5.ex3.game.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

import br.com.raphaelfury.core.panel.PanelBuilder;
import br.com.raphaelfury.lp.exercises.semestre_5.ex3.game.Game;

public class GameMap {
	
	private static final HashMap<Integer, Game> games = new HashMap<>();
	
	public Game add(Game game) {
		if(getGame(game.getId()) == null)
			return games.put(game.getId(), game);
		else
			//System.out.println("Jogo existente");
			new PanelBuilder("ERRO").message("O jogo inserido já existe", "Adição", 3);
		
		return null;
	}
	
	public Game remove(int id) {
		if(getGame(id) == null) 
			new PanelBuilder("ERRO").message("O jogo inserido é inexistente", "Remoção", 3);
		 else 
			return games.remove(id);
		
		return null;
	}
	
	public Game getGame(int id) {
		return games.get(id);
	}
	
	public Collection<Game> getGames() {
		return games.values();
	}
	
	public Stream<Game> getStream() {
		return getGames().stream();
	}

}
