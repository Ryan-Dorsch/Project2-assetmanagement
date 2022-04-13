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

import com.revature.pms.model.Pokemon;
import com.revature.pms.repo.PokemonRepository;


@Component
public class PokemonDataLoader implements CommandLineRunner {
	
	@Autowired
	PokemonRepository pokemonRepository;

	@Override
	public void run(String... args) throws Exception {
		if (pokemonRepository.count() == -1) {
			loadPokemonData();
		}
	}
	
	private void loadPokemonData() {
//		String pokemonUrl = "https://pokeapi.co/api/v2/pokemon/{id}";
//		String speciesUrl = "https://pokeapi.co/api/v2/pokemon-species/{id}";
//		RestTemplate restTemplate = new RestTemplate();
//		HttpHeaders headers = new HttpHeaders();
//        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//        headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		
//		String name;
//		Integer height;
//		Integer weight;
//		String type1;
//		String type2;
//		String spriteUrl;
//		String description = "Not found :(";
//		Integer catchRate;
//		Pokemon p = new Pokemon();
//		for (int i = 1; i < 152; i++) {
//			ResponseEntity<String> pokemon = restTemplate.exchange(pokemonUrl, HttpMethod.GET, entity, String.class, i);
//			ResponseEntity<String> speciesJson = restTemplate.exchange(speciesUrl, HttpMethod.GET, entity, String.class, i);
//			JsonParser springParser = JsonParserFactory.getJsonParser();
//			Map<String, Object> map = springParser.parseMap(pokemon.getBody());
//			Map<String, Object> speciesMap = springParser.parseMap(speciesJson.getBody());
//			List<Object> types = (List) map.get("types");
//			Map<String, Object> t1 = (Map) types.get(0);
//			Map<String, Object> t2 = new HashMap();
//			if (types.size() > 1) {
//				t2 = (Map) types.get(1);
//			} else {
//				Map tMap = new HashMap<String, String>();
//				tMap.put("name", "none");
//				t2.put("type", tMap);
//			}
//			List<Object> flavorList = (List) speciesMap.get("flavor_text_entries");
//			Map<String, Object> flavorTown;
//			String version;
//			int versionIndex = 0;
//			for (int ind = 0; ind < flavorList.size(); ind++) {
//				flavorTown = ((Map) flavorList.get(ind));
//				version = ((Map) flavorTown.get("version")).get("name").toString();
//				if (version.equals("red")) {
//					description = flavorTown.get("flavor_text").toString();
//					description = description.replaceAll("(?:-)[\\n]", "-");
//					description = description.replaceAll("[\\n\\f]", " ");
//					versionIndex = ind;
//					break;
//				}
//			}
//			name = (String) map.get("name");
//			height = (Integer) map.get("height");
//			weight = (Integer) map.get("weight");
//			type1 = (String) ((Map) t1.get("type")).get("name");
//			type2 = (String) ((Map) t2.get("type")).get("name");
//			spriteUrl = (String) ((Map) map.get("sprites")).get("front_default");
//			catchRate = (Integer) speciesMap.get("capture_rate");
////			if (versionIndex!=0 && versionIndex!=1) {
////			System.out.println("**************************************************************************************************************");
////			System.out.println("id: " + i + " name: " + name + " height: " + height + " weight: " + weight + " type1: " + type1 + " type2: " + type2 +
////					" catch_rate: " + catchRate +"\n\t" + "spriteUrl: " + spriteUrl + "\n\t" + "description:\n" + "\t\t"+ description + "\n\t" + "Version Index: " + versionIndex); 
////			}
//			p = new Pokemon(name, height, weight, description, catchRate, spriteUrl, type1, type2);
//			pokemonRepository.save(p);
//		}
		//System.out.println("**************************************************************************************************************");

	}
	
}