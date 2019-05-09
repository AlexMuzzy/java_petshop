 package petshop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

import javax.swing.JOptionPane;

public class writeanimal {
	
	public void writeanimaltofile(ArrayList<animal> currentlist) throws IOException {
		BufferedWriter buffw = null;
		currentlist.sort(Comparator.comparing(animal::getSellingDate, Comparator.nullsFirst(String::compareTo)).thenComparing(animal::getArrivalDate));
		try {
			buffw = new BufferedWriter(new FileWriter("animallist.txt"));
			for (animal i : currentlist) {
				buffw.write(
					i.getName() + ", " +
					i.getSpecies() + ", " +
					i.getPrice() + ", " +
					i.getSex() + ", " +
					i.getColour() + ", " +
					i.getArrivalDate()
				);
				if (!i.getSellingDate().equals("")) {
					buffw.write(", " + i.getSellingDate());
				}
				buffw.newLine();
			}
			JOptionPane.showMessageDialog(
					null, 
					"file successfully written as animallist.txt." , 
					"Animal File Written",
					JOptionPane.INFORMATION_MESSAGE
			);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (buffw != null) {
				buffw.close();
			}
		}
	}
}
