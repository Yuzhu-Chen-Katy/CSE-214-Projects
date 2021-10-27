// Yuzhu Chen 113516748 R04
import java.util.*;
public class VirtualLine extends ArrayList{
	ArrayList<Person> queue = new ArrayList<>();

	private int size;

	/* inheret from parent
	public boolean isEmpty() {
		return this.size==0;
	}
	*/
	
	public boolean anotherEmpty() {
		if (queue.size()<=0)
			return true;
		return false;
	}
	
	public void enqueue(Person p) {
		queue.add(p);
		size++;
	}
	
	public Person dequeue() {
		size--;
		return queue.remove(0);
	}
	
	public Person peek() {
		return queue.get(0);
	}
	

}
