import java.util.Stack;
public class PackageStack  {
	private final int CAPACITY=7;
	private int top;
	private Package[] data;
	
	public PackageStack() {
		this.top=-1;
		this.data = new Package[7];
	}
	
	public void push(Package x)throws FullStackException {
		if(top==CAPACITY-1)
			throw new FullStackException("The stack is full");
		top++;
		data[top]=x;
	}
	
	public Package pop() throws EmptyStackException{
		if(top==-1)
			throw new EmptyStackException("The stack can't be empty");
		return data[top--];
	}
	
	public Package peek() throws EmptyStackException {
		if(top==-1)
			throw new EmptyStackException("The stack can't be empty");
		return data[top];
	}
	
	public boolean isFull() {
		if(top==CAPACITY-1)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty() {
		if(top==-1)
			return true;
		else
			return false;
	}
	
	public String toString() {
		String toReturn = "";
		for (int i = 0; i<CAPACITY;i++) {
		if(top==-1)
			return("empty.");
		else {
		    
			}
		}	
		
		return toReturn;	
		
	}
	

}
