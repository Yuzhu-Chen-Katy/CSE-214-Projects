//Yuzhu Chen 113516748 R04
import java.util.Locale;
import java.util.Scanner;

public class OilChangeManager {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean stop = true;
		CarList joe = new CarList();
		CarList donny = new CarList();
		CarList finish = new CarList();

		Car cutHolder = null;
		while (stop) {
			printMenu();
			System.out.println("Please select an option: ");
			String opt = input.nextLine().toUpperCase().charAt(0)+"";

			switch(opt){
			case "L":
				CarList instant;
				System.out.println("Please select a list - Joe (J) or Donny (D):");
				String secondOpt = input.nextLine().toUpperCase().charAt(0)+"";
				if (secondOpt.equals("J"))
					instant = joe;
				else if (secondOpt.equals("D"))
					instant = donny;
				else{
					System.out.println("Please choose a correct List!!!");
					break;
				}

				printOptions();
				System.out.println("Please select an option: ");
				String thridOpt = input.nextLine().toUpperCase().charAt(0)+"";
				switch (thridOpt){
					case "A":
						Make m1=null;
						String vehicleType1="";
						try {
							System.out.println("Please enter vehicle make " +
									"(Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln)");
							vehicleType1 = input.nextLine().toUpperCase();
							m1 = Make.valueOf(vehicleType1);
							System.out.println("Please enter owner's name: ");
							String name = input.nextLine();

							instant.appendToTail(new Car(m1,name));
							if(secondOpt.equals("J"))
							System.out.println(name+"'s "+m1+" has been scheduled for an oil change with Joe" +
									" and has been added to his list.");
							else if(secondOpt.equals("D"))
								System.out.println(name+"'s "+m1+" has been scheduled for an oil change with Donny" +
										" and has been added to his list.");

						}catch (IllegalArgumentException e){
							System.out.println("We don't service "+vehicleType1);
						}
						break;
					case "F":
						try {
							instant.cursorForward();
							if(secondOpt.equals("J"))
								System.out.println("Cursor Moved Forward in Joe's List");
							else if(secondOpt.equals("D"))
								System.out.println("Cursor Moved Forward in Donny's List");
						}catch (Exception e){
							System.out.println(e.getMessage());
						}
						break;
					case "H":
						instant.setCursor(instant.getHead());
						if(secondOpt.equals("J"))
							System.out.println("Cursor Moved To Head in Joe's List.");
						else if(secondOpt.equals("D"))
							System.out.println("Cursor Moved To Head in Donny's List.");
						break;
					case "T":
						instant.setCursor(instant.getTail());
						if(secondOpt.equals("J"))
							System.out.println("Cursor Moved To Tail in Joe's List.");
						else if(secondOpt.equals("D"))
							System.out.println("Cursor Moved To Tail in Donny's List.");
						break;
					case "B":
						try {
							instant.cursorBackward();
							if(secondOpt.equals("J"))
								System.out.println("Cursor Moved Backward in Joe's List.");
							else if(secondOpt.equals("D"))
								System.out.println("Cursor Moved Backward in Donny's List.");
						}catch (Exception e){
							System.out.println(e.getMessage());
						}
						break;
					case "I":
						Make m2 = null;
						String vehicleType="";
						try {
							System.out.println("Please enter vehicle make " +
									"(Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln)");
							vehicleType = input.nextLine().toUpperCase();
							m2 = Make.valueOf(vehicleType);
							System.out.println("Please enter owner's name: ");
							String name = input.nextLine();

							instant.insertBeforeCursor(new Car(m2,name));
							if(secondOpt.equals("J"))
								System.out.println(name+"'s "+m2+" has been scheduled for an oil change with Joe" +
										" and has been added to his list before the cursor.");
							else if(secondOpt.equals("D"))
								System.out.println(name+"'s "+m2+" has been scheduled for an oil change with Donny" +
										" and has been added to his list before the cursor.");
						}catch (IllegalArgumentException e){
							System.out.println("We don't service "+vehicleType);
						}
						break;
					case "X":
						try {
							cutHolder = instant.removeCursor();
							if(secondOpt.equals("J"))
								System.out.println("Cursor cut in Joe's List.");
							else if(secondOpt.equals("D"))
								System.out.println("Cursor cut in Donny's List.");
						}catch (Exception e){
							System.out.println(e.getMessage());
						}
						break;
					case "V":
						try{
							if (cutHolder == null){
								System.out.println("Didn't cut yet");
								break;
							}
							instant.insertBeforeCursor(cutHolder);
							if(secondOpt.equals("J"))
								System.out.println("Cursor pasted in Donny's List.");
							else if(secondOpt.equals("D"))
								System.out.println("Cursor pasted in Donny's List.");
						}catch (Exception e){
							System.out.println(e.getMessage());
							System.out.println("Nothing to paste.");
						}
						break;
					case "R":
						try {
							instant.removeCursor();
							if(secondOpt.equals("J"))
							System.out.println("Cursor removed in Joe's List.");
							else if(secondOpt.equals("D"))
								System.out.println("Cursor removed in Donny's List.");
						}catch (Exception e){
							System.out.println(e.getMessage());
						}
						break;
					default:
						System.out.println("Please Type a formal option.....");
						break;
				}

				break;
			case "M":
				System.out.println("Please select a destination list - Joe (J) or Donny (D):");
				String listOpt = input.nextLine().toUpperCase().charAt(0)+"";

				if (listOpt.equals("J")){
					CarListNode instantcursor = donny.getHead();
					for(int i = 0;i<donny.numCars();i++){
						joe.appendToTail(instantcursor.getData());
						try {
							donny.removeCursor();
						}catch(Exception e){
							System.out.println(e.getMessage());
						}
					}
					System.out.println("Donny's list merged into Joe's.");
				}else if(listOpt.equals("D")){
					CarListNode instantcursor = joe.getHead();
					for(int i = 0;i<joe.numCars();i++){
						donny.appendToTail(instantcursor.getData());
						try {
							joe.removeCursor();
						}catch(Exception e){
							System.out.println(e.getMessage());
						}
					}
					System.out.println("Joe's list merged into Donny's.");
				}
				break;
			case "P":
				System.out.println("Joe's List:");
				System.out.println("Maker\tOwner");
				System.out.println("--------------------");
				System.out.println(joe.toString()+"\n");

				System.out.println("Donny's List:");
				System.out.println("Maker\tOwner");
				System.out.println("--------------------");
				System.out.println(donny.toString());

				System.out.println("Finish List:");
				System.out.println("Maker\tOwner");
				System.out.println("--------------------");
				System.out.println(finish.toString());
				break;
			case "F":
				CarListNode instantcursor = joe.getHead();
				for(int i = 0;i<joe.numCars();i++){
					finish.appendToTail(instantcursor.getData());
				}
				instantcursor = donny.getHead();
				for(int i = 0;i<donny.numCars();i++){
					finish.appendToTail(instantcursor.getData());
				}
				System.out.println("Car pasted in finished list.");
				break;
			case "S":
				//TODO Extra
				break;
			case "Q":
				System.out.println("Exiting...");
				stop = false;
				break;
			}//end of first switch
		}// end of while
		input.close();
	}

	private static void printMenu() {
		System.out.println("Menu:\r\n" + "\r\n" + "     L) Edit Job Lists for Joe and Donny\r\n" + "\r\n"
				+ "     M) Merge Job Lists\r\n" + "\r\n" + "     P) Print Job Lists\r\n" + "\r\n"
				+ "     F) Paste car to end of finished car list\r\n" + "\r\n"
				+ "     S) Sort Job Lists \r\n" + "\r\n"
				+ "     Q) Quit");
	}

	private static void printOptions() {
		System.out.println("Options:\r\n" + "\r\n" + "     A) Add a car to the end of the list\r\n" + "\r\n"
				+ "     F) Cursor Forward\r\n" + "\r\n" + "     H) Cursor to Head\r\n" + "\r\n"
				+ "     T) Cursor to Tail\r\n" + "\r\n" + "     B) Cursor Backward\r\n" + "\r\n"
				+ "     I) Insert car before cursor\r\n" + "\r\n" + "     X) Cut car at cursor\r\n" + "\r\n"
				+ "     V) Paste before cursor\r\n" + "\r\n" + "     R) Remove cursor");
	}

}
