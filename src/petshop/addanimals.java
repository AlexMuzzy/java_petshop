package petshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class addanimals {
	
	private BufferedReader br;
	public addanimal a = new addanimal();

	public ArrayList<animal> filetoanimallist(){
		
		try {
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showOpenDialog(chooser);

			if (result == JFileChooser.APPROVE_OPTION) {
				
				File selectedFile = chooser.getSelectedFile();
				br = new BufferedReader(new FileReader(selectedFile));
				
				Object[] tableLines = br.lines().toArray();
				ArrayList<animal> animallist = new ArrayList<animal>();
				for (int i = 0; i < tableLines.length; i++) {
					String line = tableLines[i].toString();
					String[] dataRow = line.split(", ");
					animallist = a.addanimaltolist(animallist, dataRow);
				}
				return animallist;
			}
		}    
		catch (FileNotFoundException e) {
	      // can be thrown when creating the FileReader/BufferedReader
	      // deal with the exception
	      e.printStackTrace();
		}
		return null;
	}
}

