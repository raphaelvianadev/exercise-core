package br.com.raphaelfury.lp.exercises.semestre_4.ex5.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.raphaelfury.lp.exercises.semestre_4.ex5.objects.Predio;

public class MapManager {
	
	private static final HashMap<UUID, Predio> predios = new HashMap<>();

	public void addPredio(Predio predio) {
		predios.put(predio.getUniqueId(), predio);
	}

	public Predio getPredio(UUID uuid) {
		return predios.get(uuid);
	}

	public HashMap<UUID, Predio> getPrediosVariable() {
		return predios;
	}
	
	public Collection<Predio> getPredios() {
		return predios.values();
	}

    public Collection<Predio> getPredios(Predicate<Predio> filter) {
        return getPredios().stream().filter(filter).collect(Collectors.toList());
    }
    
    public void forEach(Consumer<Predio> consumer) {
    	getPredios().forEach(consumer);
    }
    
    public Stream<Predio> getStream() {
        return getPredios().stream();
    }

}
