package l01_queue;

class L01MyCircularQueue {
	private int[] queue;
	private int headIndex;
	private int count;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public L01MyCircularQueue(int k) {
		queue = new int[k];
		headIndex = 0;
		count = 0;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is successful.
	 */
	public boolean enQueue(int value) {
		if (count == queue.length) {
			return false;
		}

		queue[(headIndex + count) % queue.length] = value;
		count++;

		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is successful.
	 */
	public boolean deQueue() {
		if (count == 0) {
			return false;
		}

		headIndex = (headIndex + 1) % queue.length;
		count--;

		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		if (count == 0) {
			return -1;
		}

		return queue[headIndex];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		if (count == 0) {
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
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */