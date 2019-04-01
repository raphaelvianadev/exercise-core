package br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.raphaelfury.lp.exercises.semestre_5.ex1.manager.Product;

public class ProductMap {
	
	private static final HashMap<Integer, Product> products = new HashMap<>();

	public void addProduct(Product product) {
		products.put(product.getId(), product);
	}

	public Product getProduct(Integer code) {
		return products.get(code);
	}

	public HashMap<Integer, Product> getProductsVariable() {
		return products;
	}
	
	public Collection<Product> getProducts() {
		return products.values();
	}

    public Collection<Product> getProducts(Predicate<Product> filter) {
        return getProducts().stream().filter(filter).collect(Collectors.toList());
    }
    
    public void forEach(Consumer<Product> consumer) {
    	getProducts().forEach(consumer);
    }
    
    public Stream<Product> getStream() {
        return getProducts().stream();
    }

}
