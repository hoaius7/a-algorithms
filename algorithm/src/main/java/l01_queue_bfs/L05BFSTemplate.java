package l01_queue_bfs;

/**
 * BFS:
 * - do traversal
 * - find the shortest path
 */

public class L05BFSTemplate {

	/**
	 * Return the length of the shortest path between root and target node.
	 * 1. In each round, the nodes in the queue are the nodes which are waiting to be processed.
	 * 2. After each outer while loop, we are one step farther from the root node. The variable step 
	 * indicates the distance from the root node and the current node we are visiting.
	 */
	/*
	int BFS(Node root, Node target) {
	    Queue<Node> queue;  // store all nodes which are waiting to be processed
	    int step = 0;       // number of steps neeeded from root to current node
	    // initialize
	    add root to queue;
	    // BFS
	    while (queue is not empty) {
	        step = step + 1;
	        // iterate the nodes which are already in the queue
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            Node cur = the first node in queue;
	            return step if cur is target;
	            for (Node next : the neighbors of cur) {
	                add next to queue;
	            }
	            remove the first node from queue;
	        }
	    }
	    return -1;          // there is no path from root to target
	}
	*/
	
	/**
	 * to avoid getting stuck in an infinite loop (graph with cycle)
	 * => never visit a node twice: HashSet
	 */
	/*
	int BFS(Node root, Node target) {
	    Queue<Node> queue;  // store all nodes which are waiting to be processed
	    Set<Node> visited;  // store all the nodes that we've visited
	    int step = 0;       // number of steps neeeded from root to current node
	    // initialize
	    add root to queue;
	    add root to visited;
	    // BFS
	    while (queue is not empty) {
	        step = step + 1;
	        // iterate the nodes which are already in the queue
	        int size = queue.size();
	        for (int i = 0; i < size; ++i) {
	            Node cur = the first node in queue;
	            return step if cur is target;
	            for (Node next : the neighbors of cur) {
	                if (next is not in visited) {
	                    add next to queue;
	                    add next to visited;
	                }
	                remove the first node from queue;   
	            }
	        }
	    }
	    return -1;          // there is no path from root to target
	}
	*/
	
	public static void main(String[] args) {
	}

}
