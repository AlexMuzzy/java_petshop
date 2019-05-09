package petshop;

public class animal {
    private String Name;
    private String Species;
    private Double price;
    private String sex;
    private String Colour;
    private String arrivalDate;
    private String sellingDate;


    animal(String Name, String Species, Double price, String sex, String Colour, String arrivalDate, String sellingDate){
        this.Name = Name;
        this.Species = Species;
        this.price = price;
        this.sex = sex;
        this.Colour = Colour;
        this.arrivalDate = arrivalDate;
        this.sellingDate = sellingDate;
    }


    animal(String[] data){
        this(data[0], data[1], Double.valueOf(data[2]), data[3], data[4], data[5], data[6]);
    }
    
    public String getName() {
    	return Name;
    }
    public void setName(String Name) { 
    	this.Name = Name; 
    }
    public String getSpecies() {
    	return Species; 
    }
    public void setSpecies(String Species) { 
    	this.Species = Species; 
    }
    public Double getPrice() { 
    	return price; 
    }
    public void setPrice(Double price) {
    	this.price = price; 
    }
    public String getSex() {
    	return sex; 
    }
    public void setSex(String sex) {
    	this.sex = sex; 
    }
    public String getColour() {
    	return Colour; 
    }
    public void setColour(String Colour) {
    	this.Colour = Colour;
    }
    public String getArrivalDate() {
    	return arrivalDate; 
    }
    public void setArrivalDate(String arrivalDate) { 
    	this.arrivalDate = arrivalDate;
    }
    public String getSellingDate() { 
    	return sellingDate; 
    }
    public void setSellingDate(String sellingDate) {
    	this.sellingDate = sellingDate;
    }
}
