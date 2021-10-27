import java.util.ArrayList;
import java.util.List;

public class Ride {
	private int duration;
	private int timeLeft = 0;
	private String name;
	private int capacity;
	VirtualLine virtualLine = new VirtualLine();
	HoldingQueue holdingQueue = new HoldingQueue();
	List<Person> peopleOnRide = new ArrayList<>();

	public Ride(String name, int duration, int capacity) {
		this.name = name;
		this.duration = duration;
		this.capacity = capacity;
	}

	public void resetTimeLeft() {
		this.timeLeft = this.duration;
	}
	public void reduceTime(){
		this.timeLeft--;
	}
	public int getTimeLeft() {
		return timeLeft;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public String toString(){
		String toReturn = "";
		toReturn += "Blue Scream of Death - Time remaining: "+this.getTimeLeft()+"\n";

		int gold = 0;
		int silver = 0;
		int regular = 0;
		for (Person p:this.peopleOnRide){
			if (p.getMaxLine()==1)
				regular++;
			else if (p.getMaxLine()==2)
				silver++;
			else
				gold++;
		}
		toReturn += "On-ride: Gold:"+gold+", Silver:"+silver+", Regular:"+regular+"\n";

		gold = 0;
		silver = 0;
		regular = 0;
		for (Person p:this.holdingQueue.queue){
			if (p.getMaxLine()==1)
				regular++;
			else if (p.getMaxLine()==2)
				silver++;
			else
				gold++;
		}
		toReturn += "Holding Queue: Gold:"+gold+", Silver:"+silver+", Regular:"+regular+"\n";

		gold = 0;
		silver = 0;
		regular = 0;
		for (Person p:this.virtualLine.queue){
			if (p.getMaxLine()==1)
				regular++;
			else if (p.getMaxLine()==2)
				silver++;
			else
				gold++;
		}
		toReturn += "Virtual Queue: Gold:"+gold+", Silver:"+silver+", Regular:"+regular+"\n";

		return toReturn;
	}

}
