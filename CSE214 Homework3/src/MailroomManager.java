import java.util.Scanner;
public class MailroomManager {
	public static int checkStack(String name) {
		int value =name.toUpperCase().charAt(0);
		int check=0;
		if(value>=65&&value<=71)
			check=1;
		else if(value>71&&value<=74)
			check = 2;
		else if(value>74&&value<=77)
			check=3;
		else if(value>77&&value<=82)
			check=4;
		else if(value>82&&value<=90)
			check=5;
		return check;	
	}
	public static void main(String[] args) throws FullStackException {
		// TODO Auto-generated method stub
		PackageStack stack1= new PackageStack();
		PackageStack stack2 = new PackageStack();
		PackageStack stack3 = new PackageStack();
		PackageStack stack4 = new PackageStack();
		PackageStack stack5 = new PackageStack();
		PackageStack floor = new PackageStack();
		Package pack = new Package();
		int arrivalData=0;
		Scanner input = new Scanner(System.in);
		boolean stop = true;
		while(stop) {
			printMenu();
			System.out.println("Please select an option: ");
			String opt = input.nextLine().toUpperCase().charAt(0)+"";
			switch(opt) {
			case"D":
				System.out.println("Please enter recipient name: ");
				String recipient = input.nextLine();
				System.out.println("Please enter the weight (lbs): ");
				double weight=input.nextDouble();
				try {
					int check = checkStack(recipient);
					if(check==1)
						stack1.push(pack);
					else if(check==2)
						stack2.push(pack);
					else if(check==3)
						stack3.push(pack);
					else if(check==4)
						stack4.push(pack);
					else if(check==5)
						stack5.push(pack);
				}catch(FullStackException e)  {
					System.out.println(e.getMessage());
				}
				System.out.println(stack2);
				System.out.println(stack1);
				System.out.println("A "+ weight+ " lb package is awaiting pickup by "+recipient);
				break;
				
			case"G":
				System.out.println("Please enter the recipient name: ");
				String name=input.nextLine();
				try {
					int check = checkStack(name);
					Package o=new Package();
					if(check==1)
						o =stack1.pop();
					else if(check==2)
						o =stack2.pop();
					else if(check==3)
						o =stack3.pop();
					else if(check==4)
						o =stack4.pop();
					else if(check==5)
						o =stack5.pop();
					floor.push(o);
				} catch (EmptyStackException e) {
					e.printStackTrace();
				}
				System.out.println("Move");
				
			case"T":
				arrivalData++;
				System.out.println("It is now day "+arrivalData);
				break;
				
			case"P":
				System.out.println("Current Packages:");
				System.out.println("--------------------------------");
				System.out.println("Stack 1 (A-G): | "+stack1.toString());
				System.out.println("Stack 2 (H-J): | "+stack2.toString());
				System.out.println("Stack 3 (K-M): | "+stack3.toString());
				System.out.println("Stack 4 (N-R): | "+stack4.toString());
				System.out.println("Stack 5 (S-Z): | "+stack5.toString());
				System.out.println("Floor: | "+floor.toString());
				break;
			case"M":
				
			case"F":
				
			case"L":
				System.out.println("Please enter the recipient name: ");
				String checkname=input.nextLine();
				System.out.println(checkname+" has ");
				
			case"E":
				
			case"Q":
				System.out.println("Use Amazon Locker next time.");
				stop = false;
				break;
			}	
		}
		input.close();

	}
	
	private static void printMenu() {
		System.out.println("Menu:\r\n"
				+ "\r\n"
				+ "     D) Deliver a package\r\n"
				+ "\r\n"
				+ "     G) Get someone's package\r\n"
				+ "\r\n"
				+ "     T) Make it tomorrow\r\n"
				+ "\r\n"
				+ "     P) Print the stacks\r\n"
				+ "\r\n"
				+ "     M) Move a package from one stack to another\r\n"
				+ "\r\n"
				+ "     F) Find packages in the wrong stack and move to floor\r\n"
				+ "\r\n"
				+ "     L) List all packages awaiting a user\r\n"
				+ "\r\n"
				+ "     E) Empty the floor.\r\n"
				+ "\r\n"
				+ "     Q) Quit");
	}

}
