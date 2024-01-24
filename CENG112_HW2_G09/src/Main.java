// Osman Çelik 280201053 Rana Elif Albayrak 280201037


import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Main<T> extends ArrayStack<T>{

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		
		String[] dates = {"December 2024","November 2024","October 2024","September 2024","August 2024","July 2024","June 2024",
				"May 2024","April 2024","March 2024","February 2024","January 2024","December 2023","November 2023","October 2023",
				"September 2023","August 2023","July 2023","June 2023","May 2023","April 2023","March 2023","February 2023",
				"January 2023","December 2022","November 2022","October 2022","September 2022","August 2022","July 2022"};
		
		// creating a stack for tuna cans.
		ArrayStack<Tuna> stackTuna = new ArrayStack<Tuna>();
		
		for (String date: dates) {
			Tuna tunaCan = new Tuna(date);
			stackTuna.push(tunaCan);
		}//end for
		
		// creating a stack for corn cans.
		ArrayStack<Corn> stackCorn = new ArrayStack<Corn>();
		
		for (String date: dates) {
			Corn cornCan = new Corn(date);
			stackCorn.push(cornCan);
		}// end for
		
		// creating a stack for pudding packets.
		ArrayStack<Pudding> stackPudding = new ArrayStack<Pudding>();
		
		for (String date: dates) {
			Pudding puddingPacket = new Pudding(date);
			stackPudding.push(puddingPacket);
		}// end for	
		
		// creating a stack for instant noodle packets.
		ArrayStack<Noodle> stackNoodle = new ArrayStack<Noodle>();
		
		for (String date: dates) {
			Noodle noodlePacket = new Noodle(date);
			stackNoodle.push(noodlePacket);
		}// end for	
		
		//FOOD PILES BEFORE PROCESSING THE ORDERS.
		
		System.out.println("FOOD PILES BEFORE PROCESSING THE ORDERS");
		System.out.println("TUNA");
		System.out.println(displayStack(stackTuna.toArray()));
		System.out.println("CORN");
		System.out.println(displayStack(stackCorn.toArray()));
		System.out.println("PUDDING");
		System.out.println(displayStack(stackPudding.toArray()));
		System.out.println("NOODLE");
		System.out.println(displayStack(stackNoodle.toArray()));
		System.out.println();
		
		int [] orderID = new int[30];
		String [] orderDate = new String[30];
		String [] foodCategory1 = new String[30];
		String [] foodCategory2 = new String[30];
		String [] foodCategory3 = new String[30];
		
		int index=0;
		File ordersFile = new File("orders.csv");
		Scanner scanner = new Scanner(ordersFile);
		while(scanner.hasNextLine()) {
			String orders = scanner.nextLine();
			String[] order = orders.split(",");
			orderID[index]=Integer.parseInt(order[0]);
			orderDate[index]=order[1];
			foodCategory1[index]=order[2];
			foodCategory2[index]=order[3];
			foodCategory3[index]=order[4];
			index++;
		}// end while
		
		
		// creating a waiting line for orders.
		ArrayQueue<Order> queueOrder = new ArrayQueue<Order>();
		
		for(int i = 0; i<30; i++) {
			Order order = new Order(orderID[i],orderDate[i],foodCategory1[i],foodCategory2[i],foodCategory3[i]);
			queueOrder.enqueue(order);
		}// end for
		
		//creating cargo packets and adding them to a list.
		
		AList<CargoPacket> packetList = new AList<CargoPacket>();
		AList<CargoPacket> cargoList = new AList<CargoPacket>();
		Tuna tuna;
		Corn corn;
		Pudding pudding;
		Noodle noodle;
		String id25tuna = null ; 
		String id25corn = null; 
		String id25noodle = null;
		String id25puding = null ;
		
		
		for(int i = 0; i<30 ; i++) {
			CargoPacket packet = new CargoPacket(orderID[i],orderDate[i],foodCategory1[i],foodCategory2[i],foodCategory3[i]);
			packetList.add(packet);
			cargoList.add(packet);
			if(foodCategory1[i].equals("tuna")||foodCategory2[i].equals("tuna")||foodCategory3[i].equals("tuna")) {
				tuna = stackTuna.pop();
				if(packet.ID == 25) {
					if(packet.foodProduct1.equals("tuna")||packet.foodProduct2.equals("tuna")||packet.foodProduct3.equals("tuna")) {
						id25tuna = tuna.expirationDate ;
					}
				}
			}//end if
			if(foodCategory1[i].equals("corn")||foodCategory2[i].equals("corn")||foodCategory3[i].equals("corn")) {
				corn = stackCorn.pop();
				if(packet.ID == 25) {
					if(packet.foodProduct1.equals("corn")||packet.foodProduct2.equals("corn")||packet.foodProduct3.equals("corn")) {
						id25corn = corn.expirationDate ;
					}
				}
			}//end if
			if(foodCategory1[i].equals("noodle")||foodCategory2[i].equals("noodle")||foodCategory3[i].equals("noodle")) {
				noodle = stackNoodle.pop();
				if(packet.ID == 25) {
					if(packet.foodProduct1.equals("noodle")||packet.foodProduct2.equals("noodle")||packet.foodProduct3.equals("noodle")) {
						id25noodle = noodle.expirationDate ;
					}
				}
			}//end if
			if(foodCategory1[i].equals("pudding")||foodCategory2[i].equals("pudding")||foodCategory3[i].equals("pudding")) {
				pudding = stackPudding.pop();
				if(packet.ID == 25) {
					if(packet.foodProduct1.equals("pudding")||packet.foodProduct2.equals("pudding")||packet.foodProduct3.equals("pudding")) {
						id25puding = pudding.expirationDate ; 
					}
				}
			
			}//end if
		}// end for
		
		//sorting the cargo list according to the packet's cargo ID.
		for(int i = 0; i<30;i++) {
			CargoPacket packet = new CargoPacket(orderID[i],orderDate[i],foodCategory1[i],foodCategory2[i],foodCategory3[i]);
			cargoList.replace(packet.ID-1, packet);
		}//end for
		
		//FOOD PILES AFTER PROCESSING THE ORDERS.
		System.out.println();
		System.out.println("FOOD PILES AFTER PROCESSING THE ORDERS");
		System.out.println("TUNA");//ten items left
		System.out.println(displayStack(stackTuna.toArray()));
		System.out.println("CORN");// no items left
		System.out.println(displayStack(stackCorn.toArray()));
		System.out.println("PUDDING");// ten items left
		System.out.println(displayStack(stackPudding.toArray()));
		System.out.println("NOODLE");// ten items left
		System.out.println(displayStack(stackNoodle.toArray()));
		
		//WAITING LINE OF ORDERS
		System.out.println();
		System.out.println("WAITING LINE OF ORDERS");
		System.out.println(displayQueue(queueOrder.toArray()));
		//THE LIST OF CARGO PACKETS
		System.out.println();
		System.out.println("THE LIST OF CARGO PACKETS");
		System.out.println(displayQueue(cargoList.toArray()));
		System.out.println();
		
		
		// EXPIRATION DATES THE PRODUCTS WITH ID 25
		if(id25tuna != null) {
		System.out.println("Expiration date of the tuna in the packet with ID 25: "+ id25tuna);
		}
		if(id25corn != null) {
		System.out.println("Expiration date of the corn in the packet with ID 25: "+ id25corn);
		}
		if(id25noodle != null) {
		System.out.println("Expiration date of the noodle in the packet with ID 25: "+ id25noodle);
		}
		if(id25puding != null) {
		System.out.println("Expiration date of the puding in the packet with ID 25: "+ id25puding);
		}
		System.out.println();
		//REMOVE THE CARGO PACKET WITH ID 20 FROM CARGO LIST AND PRINT THE CONTENTS OF CARGO LIST AGAIN
		System.out.println("REMOVE THE CARGO PACKET WITH ID 20 FROM CARGO LIST AND PRINT THE CONTENTS OF CARGO LIST AGAIN");
		cargoList.remove(19);
		System.out.println(displayList(cargoList.toArray()));
		
		
		
	}

}
