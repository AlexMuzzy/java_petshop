package petshop;

import javax.swing.JOptionPane;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class computerevenue {
	public void computerevenuefromlist(ArrayList<animal> animallist, String dategiven) {
		Double profit = 0.0;
		String[] datearray = dategiven.split("-");
		boolean datecheck = false;			
		String message1 = "";
		String message2 = "";
		if (datearray.length == 2) {
			datecheck = true;

			String[] dategivenarr = dategiven.split("-");
			for (animal i : animallist) {
				System.out.println(i.getName());
				if (!(i.getSellingDate().equals(""))) {
					String[] currmonthyear = new String[] {i.getSellingDate().split("-")[0],i.getSellingDate().split("-")[1]};
					if (Arrays.equals(currmonthyear, dategivenarr)) {
						profit += i.getPrice();
					}
				}
			}
			
			message1 = "The year " + dategivenarr[0] + ", and the month of " + dategivenarr[1] + ", have made " + NumberFormat.getCurrencyInstance(Locale.UK).format(profit);
			message2 = "Compute Monthly";
			
		} else if (datearray.length == 3) {
			datecheck = true;
			for (animal j : animallist) {
				if (dategiven.equals(j.getSellingDate())) {
					
					profit += j.getPrice();
				}
			}
			
			message1 = "The date " + dategiven + " made " + NumberFormat.getCurrencyInstance(Locale.UK).format(profit);
			message2 = "Compute Date Revenue";
		}
		
		if (datecheck == true) {;
			JOptionPane.showMessageDialog(
					null, 
					message1,
					message2,
					JOptionPane.INFORMATION_MESSAGE
			);
		}
	}
}
