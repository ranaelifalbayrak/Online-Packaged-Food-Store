
public class Pudding {
    String expirationDate;
	
	String netWeight;
	String flavor;
	
	Pudding(String expirationDate){
		netWeight = "120 gr";
		flavor = "banana";
		this.expirationDate = expirationDate;
	}
	
	public String toString() {
		String myString = "Net weight: "+netWeight + "\n" + "Flavor: " + flavor+ "\n" +"Expiration Date: "+ expirationDate ;
		return myString;
	}

}
