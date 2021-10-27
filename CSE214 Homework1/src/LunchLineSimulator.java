//Yuzhu Chen 113516748 R04
import java.util.Scanner;
public class LunchLineSimulator {
	
	private static StudentLine realityA;
	
	private static StudentLine realityB;
	
	/**
	 * read the user's input and provides an interface for a user to manipulate the list
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean stop = true;
		realityA = new StudentLine();
		realityB = new StudentLine();
		StudentLine position = realityA;
		while(stop) {
			printMessage();
			System.out.println("Please select an option: ");
			String opt = input.nextLine().toLowerCase().charAt(0)+"";
			
			switch(opt) {
			case "a":
				try {
					System.out.println("Please enter student name: ");
					String name = input.nextLine();
					System.out.println("Please enter money amount: ");
					double money = input.nextDouble();
					
					if(money<0)
						throw new  IllegalArgumentException("You can't have debt in middle school.");
					
					position.addStudent(position.numStudents(),new Student(name,money));
					System.out.println( name+" has been added to the line in position "+position+
							". "+name+" has $"+money+".");
				}catch(Exception e) {
					System.out.println(e.getMessage());
                    System.out.println("Line has not changed");
				}
				break;
				
			case"c":
				try {
					System.out.println("Please enter student name: ");
					String name = input.nextLine();
					System.out.println("Please enter money amount: ");
					double money = input.nextDouble();
					
					if(money<0)
						throw new  IllegalArgumentException("You can't have debt in middle school.");
					System.out.println("Please enter position: ");
					int index=input.nextInt();
					
					position.addStudent(index-1, new Student(name,money));
					System.out.println(name+" has cut into the line inposition"+
					index+". Alex has $"+money+".");
				}catch(Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Line has not changed");
				}
				break;
				
			case"b":
				try {
					System.out.println("Please enter student's index: ");
					int index = input.nextInt();
					System.out.println("The bully has stolen"+
					position.removeStudent(index-1).getName()+
					" lunch money,out, feeling hangry.");
				}catch(Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Line has not changed");
				}
				break;
				
			case"u":
				try {
					System.out.println("Please enter student index: ");
					int index = input.nextInt();
					System.out.println("Please enter new money amount: ");
					double newMoney = input.nextDouble();
					
					if(newMoney<0)
						throw new IllegalArgumentException("You can't have debt in middle school.");
					position.getStudent(index-1).setMoney(newMoney);
					System.out.println(position.getStudent(index-1).getName()+
							" now has $"+newMoney);
				}catch(Exception e) {
					System.out.println(e.getMessage());
                    System.out.println("The lunch line has not updated.");
				}
				break;
				
			case"p":
				if(position == realityA)
					System.out.println("Printing Reality A...");
				else
					System.out.println("Printing Reality B...");
				System.out.println(position.toString());
				break;
				
			case"s":
				try {
					Student instant = position.removeStudent(0);
					System.out.println(instant.getName()+
							"today's special: Bouncy \"Chicken?\" Nuggets. We hope he lives to see another day!");
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case"o":
				if(position==realityA) {
					position = realityB;
					System.out.println("You are now in reality B");
				}
				else {
					position = realityA;
					System.out.println("You are now in reality A");
				}
				break;
				
			case "t":
				int index1;
				int index2;
				try {
					System.out.println("Please enter student1 index: ");
					index1 = input.nextInt();
					System.out.println("Please enter student1 index: ");
					index2 = input.nextInt();
					position.swapStudent(index1-1,index2-1);
				}catch(Exception e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.println(position.getStudent(index2).getName()+
						"has traded placed with "+position.getStudent(index1).getName());
				break;
				
			case"e":
				if(realityA.equals(realityB))
					System.out.println("The realities are equal.");
				else
					System.out.println("The realities are NOT equal.");
				break;
				
			case"d":
				if(position==realityA) {
					realityB=realityA.clone();
					System.out.println("Reality A has been copied into Reality B.");
				}
				else {
					realityA=realityB.clone();
					System.out.println("Reality B has been copied into Reality A.");
				}
				break;
				
			case"q":
				System.out.println("You are now leaving the Middle School Lunch Line Simulator. We congratulate you on your decision to do something more productive with your time.");
				stop = false;
				break;
			}
		}	
		
	}
	
	public static void printMessage() {
		System.out.println("Menu:\r\n"
				+ "\r\n"
				+ "     A) Add a student to the line at the end\r\n"
				+ "\r\n"
				+ "     C) Have a new student cut a friend\r\n"
				+ "\r\n"
				+ "     T) Have two students trade places\r\n"
				+ "\r\n"
				+ "     B) Have the bully remove a student\r\n"
				+ "\r\n"
				+ "     U) Update a student's money amount\r\n"
				+ "\r\n"
				+ "     S) Serve a student\r\n"
				+ "\r\n"
				+ "     P) Print the current reality's lunch line\r\n"
				+ "\r\n"
				+ "     O) Switch to the other reality\r\n"
				+ "\r\n"
				+ "     E) Check if the realities are equal\r\n"
				+ "\r\n"
				+ "     D) Duplicate this reality into the other reality\r\n"
				+ "\r\n"
				+ "     Q) Quit middle school and move on to real life.");
		
	}

}
