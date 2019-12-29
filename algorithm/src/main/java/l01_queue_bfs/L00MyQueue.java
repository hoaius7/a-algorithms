package l01_queue_bfs;

import java.util.ArrayList;
import java.util.List;

public class L00MyQueue {
	// store elements
	private List<Integer> data;
	// a pointer to indicate the start position
	private int start;

	public L00MyQueue() {
		data = new ArrayList<>();
		start = 0;
	}

	/** Insert an element into the queue. Return true if the operation is successful. */
	public boolean enQueue(int x) {
		data.add(x);
		return true;
	};

	/** Delete an element from the queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		start++;
		return true;
	}

	/** Get the front item from the queue. */
	public int peek() {
		return data.get(start);
	}

	/** Checks whether the queue is empty or not. */
	public boolean isEmpty() {
		return start >= data.size();
	}
	
	public static void main(String[] args) {
		L00MyQueue q = new L00MyQueue();
		q.enQueue(5);
		q.enQueue(3);
		
		while (!q.isEmpty()) {
			System.out.println(q.peek());
			q.deQueue();
		}
	}
}

/**
 * The implementation above is straightforward but is inefficient in some cases.
 * With the movement of the start pointer, more and more space is wasted. And it
 * will be unacceptable when we only have a space limitation.
 */