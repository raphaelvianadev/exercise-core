package br.com.raphaelfury.lp.exercises.semestre_4.ex4.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.raphaelfury.lp.exercises.semestre_4.ex4.objects.Chocolate;

public class ChocolateMap {
	
	private static final HashMap<Integer, Chocolate> chocolates = new HashMap<>();

	public void addChocolate(Chocolate chocolate) {
		chocolates.put(chocolate.getCodigo(), chocolate);
	}

	public Chocolate getChocolate(Integer code) {
		return chocolates.get(code);
	}

	public HashMap<Integer, Chocolate> getChocolatesVariable() {
		return chocolates;
	}
	
	public Collection<Chocolate> getChocolates() {
		return chocolates.values();
	}

    public Collection<Chocolate> getChocolates(Predicate<Chocolate> filter) {
        return getChocolates().stream().filter(filter).collect(Collectors.toList());
    }
    
    public void forEach(Consumer<Chocolate> consumer) {
    	getChocolates().forEach(consumer);
    }
    
    public Stream<Chocolate> getStream() {
        return getChocolates().stream();
    }

}
