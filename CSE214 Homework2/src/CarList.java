//Yuzhu Chen 113516748 R04
public class CarList {
	private CarListNode head;
	private CarListNode tail;
	private CarListNode cursor;
	private int counter;

	/**
	 * initialize the data field
	 */
	public CarList() {
		head=null;
		tail=null;
		cursor=null;
		counter=0;
	}

	/**
	 * the amount of cars
	 * @return counter
	 */
	public int numCars() {
		return counter;
	}

	/**
	 * getters and setters
	 * @return head,tail,cursor
	 */
	public CarListNode getHead(){
		return this.head;
	}
	public CarListNode getTail(){
		return this.tail;
	}
	public CarListNode getCursor(){
		return this.cursor;
	}

	public void setCursor(CarListNode cursor) {
		this.cursor = cursor;
	}

	public Car getCursorCar() {
		if(cursor==null)
			return null;
		return cursor.getData();
	}

	/**
	 * set cursor to head
	 */
	public void resetCursorToHead() {
		if(head==null)
			cursor=null;
		else
			cursor=head;
	}

	/**
	 * move cursor forward
	 * @throws EndOfListException
	 */
	public void cursorForward() throws EndOfListException {
		if(cursor==tail)
			throw new EndOfListException("The cursor is at the end of list");
		else
			cursor=cursor.getNext();
	}

	/**
	 * move cursor backward
	 * @throws EndOfListException
	 */
	public void cursorBackward() throws EndOfListException {
		if(cursor==head)
			throw new EndOfListException("The cursor is at the head of list");
		else
			cursor=cursor.getPrev();
	}

	/**
	 * insert car before cursor
	 * @param newCar
	 */
	public void insertBeforeCursor(Car newCar) {
		if(newCar==null)
			throw new IllegalArgumentException("The newCar can't be null");
		CarListNode newNode= new CarListNode(newCar);
		if(cursor!=null) {
			if(cursor.getPrev()!=null) {
				newNode.setNext(cursor);
				cursor.getPrev().setNext(newNode);
				newNode.setPrev(cursor.getPrev());
				cursor.setPrev(newNode);
			}
			else {
				head=newNode;
				newNode.setNext(cursor);
				cursor.setPrev(newNode);
			}	
		}
		else {
			head=newNode;
			tail=newNode;
			cursor=newNode;
		}
		counter+=1;	
	}

	/**
	 * add a car to the end of list
	 * @param newCar
	 */
	public void appendToTail(Car newCar) {
		if(newCar==null)
			throw new IllegalArgumentException("The newCar can't be null");
		CarListNode newNode= new CarListNode(newCar);
		if(tail!=null) {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail=newNode;
		}
		else {
			head=newNode;
			tail=newNode;
			cursor=newNode;
		}
		counter+=1;
		
	}

	/**
	 * remove cursor
	 * @return new cursor
	 * @throws EndOfListException
	 */
	public Car removeCursor() throws EndOfListException {
		if(cursor==null)
			throw new EndOfListException("The cursor can't be null");
		CarListNode returnNode=cursor;
		if(cursor==head&&cursor!=tail) {
			head=cursor.getNext();
			head.setPrev(null);
			cursor=head;
		}
		else if(cursor==tail&&cursor!=head) {
			tail=cursor.getPrev();
			tail.setNext(null);
			cursor=tail;
		}
		else if(cursor!=head&&cursor!=tail) {
			cursor.getPrev().setNext(cursor.getNext());
			cursor.getNext().setPrev(cursor.getPrev());
			cursor=cursor.getPrev();
		}
		else {
			cursor=null;
			head=null;
			tail=null;
		}
		counter-=1;
		return returnNode.getData();
	}

	/**
	 * print the lists
	 * @return toReturn
	 */
	public String toString() {
		if (this.head == null)
			return "[empty]";

		String toReturn = "";

		CarListNode instantCursor = this.head;
		for (int i = 0; i< this.counter;i++){
			if (instantCursor != this.cursor){
				toReturn += instantCursor.getData().getMake()+
						"\t"+instantCursor.getData().getOnwer()+"\n";
			}else {
				toReturn += "->"+instantCursor.getData().getMake()+
						"\t"+instantCursor.getData().getOnwer()+"\n";
			}
			instantCursor=instantCursor.getNext();
		}
		return toReturn;
	}
	
	
	

}

