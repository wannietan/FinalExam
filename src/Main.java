import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Vector<Gelato> vBee = new Vector<>();
	String[] Type = new String [6];
	int[] ConePrice = new int[6];
	int[] SundaePrice = new int[6];
	String[] Option = new String [3];
	String[] Topping = new String[5];
	int[] ToppingPrice = new int[5];

	
	int scanInt() {
		int input;
		try {
			input = scan.nextInt();
		} catch (Exception e) {
			input = Integer.MIN_VALUE;
		}
		scan.nextLine();
		return input;
	}
	
	public Main() {
		int choose = -1;
		do {
			System.out.println("BEE GELATO");
			System.out.println("==========");
			System.out.println("1. Order");
			System.out.println("2. Order History");
			System.out.println("3. Exit");
			System.out.print(">>");
			choose = scanInt();
			switch (choose) {
			case 1:
				MenuOrder();
				break;
			case 2:
				MenuOrderHistory();
				break;
			case 3:
				menu3();
				break;
			}
		} while (choose!=3);
		
	}
	
	public void array() {
		Type[0] = "";
		Type[1] = "Strawberry"; 
		Type[2] = "Coklat"; 
		Type[3] = "Vanilla"; 
		Type[4] = "Durian"; 
		Type[5] = "Blueberry"; 
		
		ConePrice[0] = 0;
		ConePrice[1] = 10000;
		ConePrice[2] = 9000;
		ConePrice[3] = 8000;
		ConePrice[4] = 12000;
		ConePrice[5] = 11000;
		
		SundaePrice[0] = 0;
		SundaePrice[1] = 12000;
		SundaePrice[2] = 11000;
		SundaePrice[3] = 10000;
		SundaePrice[4] = 14000;
		SundaePrice[5] = 13000;
		
		Option[0] = "";
		Option[1] = "Cone";
		Option[2] = "Sundae";
		
		Topping[0] = "No Topping";
		Topping[1] = "Almond";
		Topping[2] = "Nut";
		Topping[3] = "Oreo";
		Topping[4] = "Messes";
	}

	public void MenuOrder() {
		int noOdr = -1;
		int type = -1;
		int cOs = -1;
		int topp = -1;
		int qty = -1;
		do {
			System.out.print("Input 'No Order' [1 - 10000]: ");
			noOdr = scanInt();
			for (int i = 0; i < vBee.size(); i++) {
				if (noOdr == vBee.get(i).getNoOdr()) {
					System.out.println("No order yang dimasukkan sudah ada!");
				}
			}
		} while (noOdr < 1 || noOdr > 10000);
		
		do {
			System.out.print("Type (1.Strawberry 2.Coklat 3.Vanilla 4.Durian 5.Blueberry): ");
			type = scanInt();
		} while (type < 1 || type > 5);
		
		do {
			System.out.print("Cone/Sundae (1.Cone 2.Sundae): ");
			cOs = scanInt();
		} while (cOs != 1 && cOs != 2);
		
		do {
			System.out.print("Topping (0.No Topping 1.Almond 2.Nut 3.Oreo 4.Messes): ");
			topp = scanInt();
		} while (topp < 0 || topp > 4);
		
		do {
			System.out.print("Quantity: ");
			qty = scanInt();
		} while (qty < 0);
		
		System.out.println("Press Enter to Continue");
		scan.nextLine();
		
		String rasa = "";
		String tipe = "";
		String top = "";
		
		if (type == 1) {
			rasa = "Strawberry";
		}else if (type == 2) {
			rasa = "Coklat";
		}else if (type == 3) {
			rasa = "Vanilla";
		}else if (type == 4) {
			rasa = "Durian";
		}else {
			rasa = "Blueberry";
		}
		
		if (cOs == 1) {
			tipe = "Cone";
		}else {
			tipe = "Sundae";
		}
		
		if (topp == 0) {
			top = "No Topping";
		}else if(topp == 1) {
			top = "Almond";
		}else if(topp == 2) {
			top = "Nut";
		}else if(topp == 3) {
			top = "Oreo";
		}else {
			top = "Messes";
		}
		
		int harga = -1;
		if (type == 1 && cOs == 1) {
			harga = 10000;
		}else if (type == 2 && cOs == 1) {
			harga = 9000;
		}else if (type == 3 && cOs == 1) {
			harga = 8000;
		}else if (type == 4 && cOs == 1) {
			harga = 12000;
		}else {
			harga = 11000;
		}
		
		if (type == 1 && cOs == 2) {
			harga = 12000;
		}else if (type == 2 && cOs == 2) {
			harga = 11000;
		}else if (type == 3 && cOs == 2) {
			harga = 10000;
		}else if (type == 4 && cOs == 2) {
			harga = 14000;
		}else {
			harga = 13000;
		}
		
		
		int hargaTopp = -1;
		if (top == "No Topping") {
			hargaTopp = 0;
		}else if (top == "Almond") {
			hargaTopp = 3000;
		}else if (top == "Nut") {
			hargaTopp = 2500;
		}else if (top == "Oreo") {
			hargaTopp = 1500;
		}else {
			hargaTopp = 2000;
		}
		
		int price = harga + hargaTopp;
		
		int subtotal = price*qty;
		
		Gelato newBee = new Gelato();
		newBee.setNoOdr(noOdr);
		newBee.setType(rasa);
		newBee.setcOs(tipe);
		newBee.setTopp(top);
		newBee.setQty(qty);
		newBee.setPrice(price);
		newBee.setSubtotal(subtotal);
		vBee.add(newBee);
	}
	
	public void MenuOrderHistory() {
		System.out.println("=========================================================================================================");
		System.out.printf("| %-3s | %-10s | %-10s | %-10s | %-10s |  %-10s | %-10s | %-10s | \n", "No", "No Order", "Ice Cream Type", "Topping", "Cone/Sundae", "Quantity", "Price", "Sub Total");
		System.out.println("=========================================================================================================");
		for (int i = 0; i < vBee.size(); i++) {
			System.out.printf("| %-3s | %-10s | %-10s | %-10s | %-10s |  %-10s | %-10s | %-10s | \n", (i+1), vBee.get(i).getNoOdr(), vBee.get(i).getType(), vBee.get(i).getTopp(), vBee.get(i).getcOs(), vBee.get(i).getQty(), vBee.get(i).getPrice(), vBee.get(i).getSubtotal());
			System.out.println("----------------------------------------------------------------------------------------------------------");
		}
	}
	
	public void menu3() {
		System.out.println("Thank You!");
	}

	public static void main(String[] args) {
		new Main();

	}

}
