package petshop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class addanimal {
	
	private String[] setADate (String[]animalrow) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime cdate = LocalDateTime.now();  
			animalrow[5] = dtf.format(cdate);
		return animalrow;
	}
	
	public  ArrayList<animal> addanimaltolist(ArrayList<animal> animallist, String[] animal) {
		String[] animalrow = new String[7];
		for (int i = 0; i < animal.length; i++) {		
				animalrow[i] = animal[i];
		}
		if (animalrow[5] != null) {
			if (animalrow[5].equals("")) {
				setADate(animalrow);
			}
		} else {
			setADate(animalrow);
		}
		
		if (animalrow[6] == null) {
			animalrow[6] = "";
		}

		animallist.add(new animal(animalrow));
		return animallist;
	}
}
