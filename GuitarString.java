public class GuitarString {
	
	private RingBuffer buffer;
	private int num;
	private int time;
	
	public GuitarString(double frequency) {
		num = (int) (44100 / frequency);
		buffer = new RingBuffer(num);
		time = 0;
		
		for(int i = 0; i < num; ++i) {
			buffer.enqueue(0.0);
		}
	}
	
	public GuitarString(double[] init) {
		num = init.length;
		buffer = new RingBuffer(num);
		time = 0;
		
		for(int i = 0; i < num; ++i) {
			buffer.enqueue(init[i]);
		}
	}
	
	
	public void pluck() {
		for(int i = 0; i < num; ++i) {			
			buffer.dequeue();
			buffer.enqueue(Math.random() -0.5);
		}
	}
	
	public void tic() {
		++time;
		double update = (buffer.dequeue() + buffer.peek()) * 0.994 / 2;
		buffer.enqueue(update);
	}
	
	public double sample() {
		return buffer.peek();
	}
	
	public int time() {
		return time;
	}
}