package petshop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class sellanimal {
	
	private String[] checkandsetSDate (String[]selectanimal) {
		if (selectanimal[6].equals("")) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime cdate = LocalDateTime.now();  
			selectanimal[6] = dtf.format(cdate);
		}	
	return selectanimal;
	}
	
	public ArrayList<animal> sellselectanimal (ArrayList<animal> animallist, int i){
			String[] selectanimal = new String[] {
					animallist.get(i).getName(),
					animallist.get(i).getSpecies(),
					animallist.get(i).getPrice().toString(),
					animallist.get(i).getSex(),
					animallist.get(i).getColour(),
					animallist.get(i).getArrivalDate(),
					animallist.get(i).getSellingDate()
			};
		animallist.set(i, new animal(checkandsetSDate(selectanimal)));
		return animallist;
	}
}
