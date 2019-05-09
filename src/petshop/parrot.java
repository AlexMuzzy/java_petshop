package petshop;

public class parrot extends species {
	
	private boolean isTalking;

	parrot(String commonName, String kind, String order, String family, String genus, String species,
			int numberOfLegs, boolean isTalking) {
		super(commonName, kind, order, family, genus, species, numberOfLegs);
		this.setTalking(isTalking);
	}

	public boolean isTalking() {
		return isTalking;
	}

	public void setTalking(boolean isTalking) {
		this.isTalking = isTalking;
	}

}
