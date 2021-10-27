
public enum Make{
	FORD ("FORD"),
	GMC("GMC"),
	CHEVY("CHEVY"),
	JEEP("JEEP"),
	DODGE("DODGE"),
	CHRYSLER("CHRYSLER"),
	LINCOLN("LINCOLN");

	private final String name;
	private Make(String s) {
		name = s;
	}

	public String getName(){
		return this.name;
	}
}




