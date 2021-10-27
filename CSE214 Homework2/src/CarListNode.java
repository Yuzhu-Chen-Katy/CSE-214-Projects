//Yuzhu Chen 113516748 R04
public class CarListNode {
	private Car data;
	private CarListNode next;
	private CarListNode prev;

	/**
	 * create initiate data
	 * @param initData
	 */
	public CarListNode(Car initData) {
		if(initData==null)
			throw new IllegalArgumentException("The initial data can't be null");
		this.data=initData;
		next=null;
		prev=null;	
	}

	/**
	 * get and set Next,Data and Previous
	 * @return next data previous
	 */
	public CarListNode getNext() {
		return next;
	}
	
	public CarListNode getPrev() {
		return prev;
	}
	
	public void setNext(CarListNode next) {
		this.next=next;
	}

	public void setPrev(CarListNode prev) {
		this.prev=prev;
	}
	
	public Car getData() {
		return data;
	}

	public void setData(Car date) {
		this.data = date;
	}

}
