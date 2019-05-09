package petshop;

public class reptile extends species {

	private boolean isVenemous;

	reptile(String commonName, String kind, String order, String family, String genus, String species,
			int numberOfLegs, boolean isVenemous) {
		super(commonName, kind, order, family, genus, species, numberOfLegs);
		this.setVenemous(isVenemous);
	}

	public boolean isVenemous() {
		return isVenemous;
	}

	public void setVenemous(boolean isVenemous) {
		this.isVenemous = isVenemous;
	}
	

}
