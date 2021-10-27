// Yuzhu Chen 113516748 R04
import java.util.*;
public class SevenFlags {

	public static void main(String[] args) {
		ArrayList<Person> regularList = new ArrayList<>();
		ArrayList<Person> silverList = new ArrayList<>();
		ArrayList<Person> goldList = new ArrayList<>();
		int time;
		int remainTime = 0;
		Ride[] rLst = new Ride[4];
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Seven Flags!\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Please enter the number of regular customers: ");
		int regular = input.nextInt();
		System.out.println("Please enter the number of silver customers: ");
		int silver = input.nextInt();
		System.out.println("Please enter the number of gold customers: ");
		int gold = input.nextInt();
		System.out.println("Please enter simulation length: ");
		int length = input.nextInt();
		//---------------------------------------------------------------------------------------
		System.out.println("Please enter the duration of Blue Scream of Death (minutes): ");
		int BSODd = input.nextInt();
		System.out.println("Please enter the capacity of Blue Scream of Death: ");
		int BSODc = input.nextInt();
		System.out.println("Please enter the holding queue size for Blue Scream of Death: ");
		int BSODs = input.nextInt();
		rLst[0] = new Ride("Blue Scream", BSODd, BSODc);
		rLst[0].holdingQueue.setMaxSize(BSODs);
		//---------------------------------------------------------------------------------------
		System.out.println("Please enter the duration of Kingda Knuth (minutes): ");
		int KKd = input.nextInt();
		System.out.println("Please enter the capacity of Kingda Knuth: ");
		int KKc = input.nextInt();
		System.out.println("Please enter the holding queue size for Kingda Knuth: ");
		int KKs = input.nextInt();
		rLst[1] = new Ride("Kingda Knuth", KKd, KKc);
		rLst[1].holdingQueue.setMaxSize(KKs);
		//---------------------------------------------------------------------------------------
		System.out.println("Please enter the duration of i386 Tower of Terror (minutes): ");
		int ToTd = input.nextInt();
		System.out.println("Please enter the capacity of i386 Tower of Terror: ");
		int ToTc = input.nextInt();
		System.out.println("Please enter the holding queue size for i386 Tower of Terror: ");
		int ToTs = input.nextInt();
		rLst[2] = new Ride("i386 Tower of Terror", ToTd, ToTc);
		rLst[2].holdingQueue.setMaxSize(ToTs);
		//---------------------------------------------------------------------------------------
		System.out.println("Please enter the duration of GeForce (minutes): ");
		int GFd = input.nextInt();
		System.out.println("Please enter the capacity of GeForce: ");
		int GFc = input.nextInt();
		System.out.println("Please enter the holding queue size for GeForce: ");
		int GFs = input.nextInt();
		rLst[3] = new Ride("GeForce", GFd, GFc);
		rLst[3].holdingQueue.setMaxSize(GFs);

		//Push person in ride
		for (int i = 0; i < gold; i++) { //gold
			Person person = new Person(i + 1);
			person.setMaxLine(3); // regular 1, silver 2, gold 3
			person.addRide(RandomGenerator.selectRide(rLst)); //first ride
			person.addRide(RandomGenerator.selectRide(rLst)); //second ride
			person.addRide(RandomGenerator.selectRide(rLst)); //thrid ride
			for (Ride j : person.getRide()) {
				pushRide(j, person);
			}
			goldList.add(person);
		}
		for (int i = 0; i < silver; i++) { // silver
			Person person = new Person(i + 1);
			person.setMaxLine(2); // regular 1, silver 2, gold 3
			person.addRide(RandomGenerator.selectRide(rLst)); //first ride
			person.addRide(RandomGenerator.selectRide(rLst)); //second ride
			for (Ride j : person.getRide()) {
				pushRide(j, person);
			}
			silverList.add(person);
		}
		for (int i = 0; i < regular; i++) { //regular
			Person person = new Person(i + 1);
			person.setMaxLine(1); // regular 1, silver 2, gold 3
			person.addRide(RandomGenerator.selectRide(rLst));
			for (Ride j : person.getRide()) {
				pushRide(j, person);
			}
			regularList.add(person);
		}

		//Main loop
		for (time = 0; time < length; time++) {
			System.out.println("At Time " + time + ":");
			//make user get in the ride and move forward
			for (Ride r : rLst) {
				forward(r);
			}

			//printing ride info
			for (Ride r : rLst) {
				System.out.println(r.toString());
				System.out.println("----------------------------------------");
			}

			//print customers' info
			System.out.println("Regular Customers: \n");
			System.out.println("Num Line Status");
			System.out.println("---------------");
			for (Person p : regularList) {
				System.out.println(p.getNumber() + ". " + p.getRide().get(0).getName()
						+ "  " + p.getStatus().getName());
			}

			System.out.println("Silver Customers: \n");
			System.out.println("Num Line1 Line2 Status");
			System.out.println("----------------------");
			for (Person p : silverList) {
				System.out.println(p.getNumber() + ". "
						+ p.getRide().get(0).getName() + " "
						+ p.getRide().get(1).getName() + " "
						+ "  " + p.getStatus().getName());
			}

			System.out.println("Gold Customers: \n");
			System.out.println("Num Line1 Line2 Line3 Status");
			System.out.println("----------------------------");
			for (Person p : goldList) {
				System.out.println(p.getNumber() + ". "
						+ p.getRide().get(0).getName() + " "
						+ p.getRide().get(1).getName() + " "
						+ p.getRide().get(2).getName() + " "
						+ "  " + p.getStatus().getName());
			}

		}

	}

	public static void pushRide(Ride r, Person p){
		//first try to push in holding queue
		if (r.holdingQueue.queue.size()>r.holdingQueue.getMaxSize()){
			//if holding is full then try virtual
			r.virtualLine.enqueue(p);
			//set person's status after push in
			p.setStatus(Status.AVA);
		}else{
			r.holdingQueue.enqueue(p);
			p.setStatus(Status.HOL);
		}
	}

	public static void forward(Ride r){
		if (r.getTimeLeft()<=0){
			if (!r.peopleOnRide.isEmpty()){ //set getting-off person's status
				for (Person p: r.peopleOnRide){
					p.setStatus(Status.AVA);
					//p.removeRide(r);
				}
			}
			r.peopleOnRide.clear(); //clear whole list

			for (int i=0;i<r.getCapacity();i++){
				//if person is not avalible, place him at the end of holding queue
				if (r.holdingQueue.queue.size()>0){
					if (r.holdingQueue.peek().getStatus()==Status.ONR){
						r.holdingQueue.enqueue(r.holdingQueue.dequeue());
					}
				}

				if (r.holdingQueue.queue.size()>0){
					Person p = r.holdingQueue.dequeue();
					p.setStatus(Status.ONR);
					r.peopleOnRide.add(p);
				}

				if (r.virtualLine.queue.size()>0){
					Person p = r.virtualLine.dequeue();
					p.setStatus(Status.HOL);
					r.holdingQueue.enqueue(p);
				}
			}
			r.resetTimeLeft();
		}else{ //time left is not 0
			r.reduceTime();
		}
	}
	

}
