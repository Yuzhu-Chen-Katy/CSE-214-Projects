//Yuzhu Chen 113516748 R04
public class StudentLine {
	private Student[] students;
	private int studentCount;
	final int CAPACITY = 20;
	
	/**
	 * This method initializes an object to an empty list of Students
	 * set studentCount to 0
	 */
	
	public StudentLine() {
		students = new Student[20];
		studentCount = 0;
	}
	/**
	 * @return the amount of students in the line
	 */
	public int numStudents() {
		return this.studentCount;
	}
	/**
	 * 
	 * @param index
	 *       the position of the student
	 * @return 
	 *       the reference of the student
	 * @throws ArrayIndexOutOfBoundsException 
	 *       when the line is full or the index<0
	 */
	public Student getStudent(int index) throws ArrayIndexOutOfBoundsException{
		if(index>=CAPACITY||index<0)
			throw new ArrayIndexOutOfBoundsException("No such index in students line");
		return students[index];
	}
	
	/**
	 * remove the student 
	 * @param index
	 *       the position of the student
	 * @return 
	 *       toReturn remove the student and move to the next position
	 * @throws EmptyLineException
	 *       when the there is no student
	 * @throws ArrayIndexOutOfBoundsException
	 *       when the line is full or the index<0
	 */
	public Student removeStudent(int index) throws EmptyLineException
	,ArrayIndexOutOfBoundsException{
		if(this.studentCount ==0)
			throw new EmptyLineException("Line is Empty");
		if(index >= CAPACITY||index<0)
			throw new ArrayIndexOutOfBoundsException("Can't remove, index out of bound");
		Student toReturn = (Student)this.students[index].clone();
		
		for(int i = index;i<CAPACITY-1;i++) {
			if(i==CAPACITY-2) {
				students[i+1]=null;
				break;
			}
			students[i] = students[i+1];
		}
		this.studentCount--;
	    return toReturn;
	}
	
	/**
	 * This method add a student to the line
	 * @param index
	 *      the position of the student
	 * @param student
	 * @throws IllegalArgumentException
	 *       when the line is full or would create a hole
	 * @throws DeanException
	 *       when the array is full
	 */
	public void addStudent(int index,Student student)throws
	 IllegalArgumentException,DeanException {
		if(students[index-1]==null)
			throw new IllegalArgumentException("Can't add, would creat hole in front");
		if(this.studentCount>=CAPACITY)
			throw new DeanException("Line is full, can't add more");
		
		for(int i=index+1;i<CAPACITY;i++) {
			students[i] = students[i-1];
		}
		students[index]=student;
		this.studentCount++;
	}
	
	/**
	 * this method swaps two students' position
	 * @param index1
	 *      the position of the first student
	 * @param index2
	 *      the position of the second student
	 * @throws ArrayIndexOutOfBoundsException
	 *       when the line is full or the index<0
	 * @throws IllegalArgumentException
	 *       when the index is null
	 */
	public void swapStudent(int index1, int index2)
			throws ArrayIndexOutOfBoundsException,IllegalArgumentException{
		if(index1>=CAPACITY||index1<0)
			throw new ArrayIndexOutOfBoundsException("index1 is out of bound");
		if(index2>=CAPACITY||index2<0)
			throw new ArrayIndexOutOfBoundsException("index2 is out of bound");
		if(students[index1]==null||students[index2]==null)
			throw new IllegalArgumentException("One of the index element is null");
		
		Student instant = students[index1];
		students[index1] = students[index2];
		students[index2]= instant;
	}
	
	/**
	 * Creates a deep copy of this StudentLine object
	 */
	public StudentLine clone() {
		StudentLine instant = new StudentLine();
		for(int i =0;i<CAPACITY;i++) {
			try {
			    instant.addStudent(i,(Student)this.getStudent(i).clone());
		    }catch(DeanException e) {
		    	System.out.println(e.getMessage());
		    }
		}
		return instant;
	}
	
	/**
	 * Checks if this student line is equal to another object
	 */
	public boolean equals(Object o) {
		if(!(o instanceof StudentLine))
			return false;
		StudentLine instant = (StudentLine)o;
		for(int i=0;i<CAPACITY;i++) {
			if(instant.getStudent(i)==null&& this.getStudent(i)==null)
				continue;
			if(instant.getStudent(i)==null&& this.getStudent(i)!=null)
				return false;
			if(instant.getStudent(i)!=null&& this.getStudent(i)==null)
				return false;
			
			if(!instant.getStudent(i).equals(this.getStudent(i)))
				return false;
		}
		return true;
	}
	
	public String toString() {
		String toReturn = "";
		for(int i=0;i<CAPACITY;i++) {
			toReturn += "Student"+i+" :";
			toReturn+="\nName: "+this.getStudent(i).getName();
			toReturn+="\nMoney: "+this.getStudent(i).getMoney();
			toReturn+="\n";
		}
		return toReturn;
	}

}
