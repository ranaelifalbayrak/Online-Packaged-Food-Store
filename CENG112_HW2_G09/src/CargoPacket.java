
public class CargoPacket {
	
    int ID;
    String processDate;
    String foodProduct1;
    String foodProduct2;
    String foodProduct3;
    
	CargoPacket(int ID, String processDate,String foodProduct1,String foodProduct2,String foodProduct3){
		this.ID=ID;
		this.processDate=processDate;
		this.foodProduct1=foodProduct1;
		this.foodProduct2=foodProduct2;
		this.foodProduct3=foodProduct3;
	}
	
	public String toString() {
		String myString = "ID: "+ID + " Process Date: " + processDate+" Products: "+foodProduct1+" "+foodProduct2+" "+foodProduct3;
		return myString;
}
}