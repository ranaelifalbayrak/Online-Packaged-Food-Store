
public class Tuna {
	
	String expirationDate;
	
	String netWeight;
	String drainedWeight;
	String ingredients;

	Tuna(String expirationDate){
		netWeight = "75 gr";
		drainedWeight = "50 gr";
		ingredients = "tuna, sunflower oil, salt";
		this.expirationDate = expirationDate;
	}
	public String toString() {
		String myString = "Net weight: "+netWeight + "\n" + "Drained weight: "+drainedWeight + "\n"+
	"Ingredients: "+ingredients + "\n" +"Expiration Date: "+ expirationDate ;
		return myString;
	}
}
