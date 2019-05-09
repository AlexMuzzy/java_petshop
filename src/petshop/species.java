package petshop;

public class species {
	private String commonName;
	private String kind;
	private String order;
	private String family;
	private String genus;
	private String species;
	private int numberOfLegs;
	
	species(String commonName, String kind, String order, String family, String genus, String species, int numberOfLegs){
        this.commonName = commonName;
        this.kind = kind;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.numberOfLegs = numberOfLegs;
	}
    species(String[] data){
        this(
        		data[0],
        		data[1],
        		data[2],
        		data[3], 
        		data[4], 
        		data[5], 
        		Integer.valueOf(data[6])
        	);
    }
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getnumberOfLegs() {
		return numberOfLegs;
	}
	public void setnumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}
    
}
