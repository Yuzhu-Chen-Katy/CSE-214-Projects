// Yuzhu Chen 113516748 R04
public enum Status {
	 AVA("Available"),
	 HOL("Holding"),
	 ONR("OnRide");
	
	private final String name;
	private Status(String s) {
		name = s;
	}

	public String getName(){
		return this.name;
	}
}
