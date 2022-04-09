package com.revature.pms.dataseed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class PokemonDataLoader implements CommandLineRunner {
	
//	@Autowired
//	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		loadPokemonData();
	}
	
	private void loadPokemonData() {
		String pokemonUrl = "https://pokeapi.co/api/v2/pokemon/{id}";
		String speciesUrl = "https://pokeapi.co/api/v2/pokemon-species/{id}";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		String name;
		String height;
		String weight;
		String type1;
		String type2;
		String spriteUrl;
		String description;
		String catchRate;
		for (int i = 1; i < 152; i++) {
			ResponseEntity<String> pokemon = restTemplate.exchange(pokemonUrl, HttpMethod.GET, entity, String.class, i);
			ResponseEntity<String> speciesJson = restTemplate.exchange(speciesUrl, HttpMethod.GET, entity, String.class, i);
			JsonParser springParser = JsonParserFactory.getJsonParser();
			Map<String, Object> map = springParser.parseMap(pokemon.getBody());
			Map<String, Object> speciesMap = springParser.parseMap(speciesJson.getBody());
			List<Object> types = (List) map.get("types");
			Map<String, Object> t1 = (Map) types.get(0);
			Map<String, Object> t2 = new HashMap();
			if (types.size() > 1) {
				t2 = (Map) types.get(1);
			} else {
				Map tMap = new HashMap<String, String>();
				tMap.put("name", "none");
				t2.put("type", tMap);
			}
			Map<String, Object> flavorTown = ((Map) ((List) speciesMap.get("flavor_text_entries")).get(0));
			name = (String) map.get("name");
			height = map.get("height").toString();
			weight = map.get("weight").toString();
			type1 = (String) ((Map) t1.get("type")).get("name");
			type2 = (String) ((Map) t2.get("type")).get("name");
			spriteUrl = (String) ((Map) map.get("sprites")).get("front_default");
			catchRate = speciesMap.get("capture_rate").toString();
			description = (String) flavorTown.get("flavor_text");
			System.out.println("id: " + i + " name: " + name + " height: " + height + " type1: " + type1 + " type2: " + type2);
		}
	}
	
}
