package l01_queue_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *	https://leetcode.com/problems/moving-average-from-data-stream/
 */
public class L04MovingAverage {
    private Queue<Integer> queue;
    private int size;
    private int count;
    private int sum;

    /** Initialize your data structure here. */
    public L04MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        this.count = 0;
        this.sum = 0;
    }
    
    public double next(int val) {
    	if (count == size) {
    		sum -= queue.poll();
    	} else {
    		count++;
    	}
    	
    	sum += val;
    	queue.offer(val);
    	
        return (double) sum / count;
    }
    
    public static void main(String[] args) {
    	L04MovingAverage m = new L04MovingAverage(3);
    	System.out.println(m.next(1));
    	System.out.println(m.next(10));
    	System.out.println(m.next(3));
    	System.out.println(m.next(5));
    }
}