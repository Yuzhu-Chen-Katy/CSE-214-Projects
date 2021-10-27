//Yuzhu Chen 113516748 R04

public class Student {
	
	private String name;
	private double money;
	
	public Student() {
		
	}
	/**
	 * getter & setter
	 * @param name
	 * @param money
	 */
	public Student(String name, double money) {
		this.name = name;
		this.money= money;
	}

	public String getName() {
		return name;
	}

	public double getMoney() {
		return money;
	}

	public void setName(String name) {
		this.name= name;
	}
	
	public void setMoney(double money) {
		this.money=money;
	}
	
	/**
	 * this method compares the object's and student's name and money
	 * @return true if the object refers to a Student object with the same properties as this Student
	 * @return false if the student's name and money is not equal to object name and money
	 */
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) {
			return false;
		}
		Student instant = (Student) obj;
		if(!instant.getName().equals(this.name))
		    return false;
		if(instant.getMoney()!= this.money)
			return false;
		return true;
	}
	
	public Object clone() {
		return new Student(this.name,this.money);
	}

	@Override
	public String toString() {
		return "Student: "+this.name+
				"\nMoney Amount: "+this.money;
	}


}
