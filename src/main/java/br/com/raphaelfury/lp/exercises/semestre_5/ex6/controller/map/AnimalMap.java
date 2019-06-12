package br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

import br.com.raphaelfury.core.panel.PanelBuilder;
import br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller.Animal;

public class AnimalMap {
	
	private static final HashMap<Integer, Animal> animals = new HashMap<>();
	
	public Animal add(Animal game) {
		if(getGame(game.getId()) == null)
			return animals.put(game.getId(), game);
		else
			new PanelBuilder("ERRO").message("O animal já existe!", "Adição", 3);
		
		return null;
	}
	
	public Animal remove(int id) {
		if(getGame(id) == null) 
			new PanelBuilder("ERRO").message("O animal inserido é inexistente", "Remoção", 3);
		 else 
			return animals.remove(id);
		
		return null;
	}
	
	public Animal getGame(int id) {
		return animals.get(id);
	}
	
	public Collection<Animal> getAnimals() {
		return animals.values();
	}
	
	public Stream<Animal> getStream() {
		return getAnimals().stream();
	}

}
