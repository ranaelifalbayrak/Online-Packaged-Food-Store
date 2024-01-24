
public class Order {
	
	String orderDate;
    int orderID;
    String food1;
    String food2;
    String food3;
    
    Order(int orderID,String orderDate,String food1,String food2,String food3){
    	this.orderID=orderID;
    	this.orderDate=orderDate;
    	this.food1=food1;
    	this.food2=food2;
    	this.food3=food3;
    }
    
    public String toString() {
		String myString = "ID: "+orderID + "\n" + "Order Date: " + orderDate+ 
				"\n" +"Foods: "+ food1+" "+food2+" "+food3 ;
		return myString;

}}
