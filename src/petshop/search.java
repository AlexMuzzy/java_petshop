package petshop;

import java.util.ArrayList;

public class search {
	public static ArrayList<species> specieslist = new ArrayList<species>();
	public static ArrayList<reptile> reptilelist = new ArrayList<reptile>();
	public static ArrayList<parrot> parrotlist = new ArrayList<parrot>();
	
	public void generatespeciessearch() {
		specieslist.add(new species("dog", "Mammalia", "Carnivora", "Canidae", "Canis", "Canis lupus", 4));
		specieslist.add(new species("cat", "Mammalia", "Carnivora", "Felidae", "Felis", "Felis silvestris", 4));
		specieslist.add(new species("Rabbit", "Mammalia", "Lagomorpha", "Leporidae", "Oryctolagus", "Oryctolagus cuniculus", 4));
		specieslist.add(new species("Golden Hamster", "Mammalia", "Rodentia", "Cricetidae", "Mesocricetus", "Mesocricetus auratus", 4));
		specieslist.add(new species("Roborovski Hamster", "Mammalia", "Rodentia", "Cricetidae", "Phodopus", "Phodopus roborovskii", 4));
		specieslist.add(new species("Yellow Canary", "Aves", "Passeriformes", "Fringillidae", "Crithagra", "Crithagra flaviventris", 2));
		specieslist.add(new species("Goldfish", "Actinopterygii", "Cypriniformes", "Cyprinidae", "Carassius", "Carassius auratus", 0));
		specieslist.add(new species("Koi", "Actinopterygii", "Cypriniformes", "Cyprinidae", "Cyprinus", "Cyprinus rubrofuscus", 0));
		specieslist.add(new species("Common Barbel", "Actinopterygii", "Cypriniformes", "Cyprinidae", "Barbus", "Barbus barbus", 0));
		
		parrotlist.add(new parrot("Edwards's Fig Parrot", "Aves", "Psittaciformes", "Psittaculidae", "Psittaculirostris", "Psittaculirostris edwardsii", 2, false));
		parrotlist.add(new parrot("Norwegian Blue", "Aves", "Psittaciformes", "Psittacidae", "Mopsitta", "Mopsitta tanta", 2, true));
		parrotlist.add(new parrot("Hyacinth Macaw", "Aves", "Psittaciformes", "Psittacidae", "Anodorhynchus", "Anodorhynchus hyacinthinus", 2, true));
		
		reptilelist.add(new reptile("Boa Constrictor", "Reptilia", "Squamata", "Boidae", "Boa", "Boa constrictor", 0, false));
		reptilelist.add(new reptile("Corn Snake", "Reptilia", "Squamata", "Colubridae", "Pantherophis", "Pantherophis guttatus", 0, false));
		reptilelist.add(new reptile("Black-necked Spitting Cobra", "Reptilia", "Squamata", "Elapidae", "Naja", "Naja nigricollis", 0, true));
		
		String[] combospecies = new String[] {"commonName", "class", "order", "family", "genus", "species", "numberOfLegs"};
		
	}
	
	public ArrayList<animal> filterlist (ArrayList<animal> animallist){
		/*
		 * create if statements to see if venemous or talking are selected, if so search upon reptile or parrot list
		 * else search all 3 lists
		 * 
		 * create if statements to check if dropdown boxes are null, if so dont bother filtering
		 * 
		 * run on key released action listener on name textbox
		 * 
		 */
		
		
		return animallist;
	}
	
}
