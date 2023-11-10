public class RingBuffer {
	
	private double maxQueue[];
	private int maxCapacity;
	private int first;
	private int last;
	
	public RingBuffer(int capacity) {
		maxQueue = new double[capacity];
		maxCapacity = capacity;
		first = 0;
		last = 0;
	}
	
	public int size() {
		return last - first;
	}
	
	public boolean isEmpty() {
		return last - first == 0;
	}
	
	public boolean isFull() {
		return last - first == maxCapacity;
	}
	
	public void enqueue(double x) {
		if(isFull()) {
			throw new IllegalStateException("Can't add an item here. The queue is already full");
		}
		else {
			maxQueue[last % maxCapacity] = x;
			++last;
		}
	}
	
	public double dequeue() {
		if(isEmpty()) {
			throw new IllegalStateException("Can't delete an item here. The queue is already empty");
		}
		else {
			double temp = maxQueue[first % maxCapacity];
			++first;
			return temp;
		}
	}
	
	public double peek() {
		if(isEmpty()) {
			throw new IllegalStateException("Can't access an item. The queue is empty");
		}
		else {
			return maxQueue[first % maxCapacity];
		}
	}
}