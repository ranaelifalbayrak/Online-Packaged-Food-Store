
public class Corn {
	
    String expirationDate;
	
	String netWeight;
	String drainedWeight;
	String productionCountry;
	
	Corn(String expirationDate){
		netWeight = "220 gr";
		drainedWeight = "132 gr";
		productionCountry = "Turkey";
		this.expirationDate = expirationDate;
	}
	
	public String toString() {
		String myString = "Net weight: "+netWeight + "\n" + "Drained weight: "+drainedWeight + "\n"+
	"Production Country: "+productionCountry + "\n" +"Expiration Date: "+ expirationDate ;
		return myString;
	}

}
