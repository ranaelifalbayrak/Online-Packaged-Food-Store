
public class Noodle {
	
    String expirationDate;
	
	String netWeight;
	String simmerDuration;
	
	Noodle(String expirationDate){
		netWeight = "120 gr";
		simmerDuration = "3 minutes";
		this.expirationDate = expirationDate;
	}
	
	public String toString() {
		String myString = "Net weight: "+netWeight + "\n" + "Simmer duration: " + simmerDuration+ 
				"\n" +"Expiration Date: "+ expirationDate ;
		return myString;
	}
}
