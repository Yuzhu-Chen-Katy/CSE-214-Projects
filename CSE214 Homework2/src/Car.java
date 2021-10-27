//Yuzhu Chen 113516748 R04
public class Car {
	private String owner;
	private Make make;

	/**
	 * get and set the brands and owners
	 * @return make owner
	 */
	public Car(Make make,String owner){
		this.make=make;
		this.owner=owner;
	}
	public Make getMake() {
		return make;
	}
	
	public String getOnwer() {
		return owner;
	}
	
	public void setMake(Make make) {
		this. make=make;
	}
	
	public void setOwner(String owner) {
		this.owner=owner;
	}

	/**
	 * Print make and owner
	 * @return make owner
	 */
	public String toString() {
		return "The brank of car: "+this.make+
				"\nOnwer is: "+this.owner;
	}

}
