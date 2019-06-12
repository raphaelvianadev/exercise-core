package br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

import br.com.raphaelfury.core.panel.PanelBuilder;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.Server;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.controller.ServerType;

public class ServerMap {
	
	private static final HashMap<Integer, Server> servers = new HashMap<>();
	
	public Server add(Server server) {
		if(getServer(server.getRegCode()) == null)
			return servers.put(server.getRegCode(), server);
		else
			new PanelBuilder("ERRO").message("O Servidor já existe!", "Adição", 3);
		
		return null;
	}
	
	public Server remove(int id) {
		if(getServer(id) == null) 
			new PanelBuilder("ERRO").message("O Servidor inserido é inexistente", "Remoção", 3);
		 else 
			return servers.remove(id);
		
		return null;
	}
	
	public ArrayList<Server> getServersType(ServerType type) {
		ArrayList<Server> specificType = new ArrayList<>();
		for (Server server : servers.values()) 
			if (server.getType().equals(type))
				specificType.add(server);
		
		return specificType;
	}
	
	public Server getServer(int id) {
		return servers.get(id);
	}
	
	public Collection<Server> getServers() {
		return servers.values();
	}
	
	public Stream<Server> getStream() {
		return getServers().stream();
	}

}
