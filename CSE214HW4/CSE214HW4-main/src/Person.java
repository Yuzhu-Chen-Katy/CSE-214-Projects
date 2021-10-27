// Yuzhu Chen 113516748 R04
import java.util.*;
public class Person {
	private int number;
	private int maxLine;
	private List<Ride> lines = new ArrayList<>();
	private Status status;
	
	public Person(int number) throws IllegalArgumentException {
		this.number=number;
		if(number<=0) {
			throw new IllegalArgumentException("The number must be positive");
		}
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getMaxLine() {
		return maxLine;
	}

	public void setMaxLine(int maxLine) {
		this.maxLine = maxLine;
	}

	public List<Ride> getRide() {
		return lines;
	}

	public void setRide(List<Ride> ride) {
		this.lines = ride;
	}

	public void addRide(Ride ride) {
		if (this.lines.size()>this.maxLine)
			return;
		this.lines.add(ride);
	}

	public void removeRide(Ride ride){
		this.lines.remove(ride);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

}
