
public class Package {
	private String recipient;
	private int arrivalData=0;
	private double weight;
	
	public Package() {
		
	}
	
	public Package(String recipient,int arrivalDate,double weight) {
		this.recipient=recipient;
		this.arrivalData=arrivalData;
		this.weight=weight;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public int getArrivalData() {
		return arrivalData;
	}

	public void setArrivalData(int arrivalData) {
		this.arrivalData = arrivalData;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return"the name is"+recipient+"the date is"+arrivalData;
	}
	

}
