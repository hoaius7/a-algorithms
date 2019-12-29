package l01_queue_bfs;

public class L01MyCircularQueue {
	private int[] queue;
	private int headIndex;
	private int count;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public L01MyCircularQueue(int k) {
		queue = new int[k];
		headIndex = 0;
		count = 0;
	}

	/**  Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if (isFull()) {
			return false;
		}

		queue[(headIndex + count) % queue.length] = value;
		count++;

		return true;
	}

	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}

		headIndex = (headIndex + 1) % queue.length;
		count--;

		return true;
	}

	/** Get the front item from the queue. */
	public int getFront() {
		if (isEmpty()) {
			return -1;
		}

		return queue[headIndex];
	}

	/** Get the last item from the queue. */
	public int getRear() {
		if (isEmpty()) {
			return -1;
		}

		return queue[(headIndex + count - 1) % queue.length];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return count == 0;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return count == queue.length;
	}
	
	public static void main(String[] args) {
		L01MyCircularQueue q = new L01MyCircularQueue(5);
		q.enQueue(5);
		q.enQueue(3);
		
		while (!q.isEmpty()) {
			System.out.println(q.getFront());
			q.deQueue();
		}
	}

}
