package l01_queue_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/open-the-lock/
The lock initially starts at '0000', a string representing the state of the 4 wheels.
You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
 */
/*
Intuition:
We can think of this problem as a shortest path problem on a graph: there are 10000 nodes (strings '0000' to '9999'), 
and there is an edge between two nodes if they differ in one digit, that digit differs by 1 (wrapping around, so '0' and '9' differ by 1), 
and if both nodes are not in deadends.

Algorithm:
- To solve a shortest path problem, we use a breadth-first search. The basic structure uses a Queue queue plus a Set seen 
that records if a node has ever been enqueued.
- For each position in the lock i = 0, 1, 2, 3, for each of the turns d = -1, 1, 
we determine the value of the lock after the i-th wheel has been turned in the direction d.
- Need to check whether '0000' is in deadends at the beginning
- Use null inputs in the queue to represent a layer change. When the layer changes, we depth++ our global counter.
 */
class L08OpenTheLock {
	public int openLock(String[] deadends, String target) {
		Set<String> deadSet = new HashSet<>();
		for (String deadend : deadends) {
			deadSet.add(deadend);
		}

		if (deadSet.contains("0000")) {
			return -1;
		}

		Queue<String> queue = new LinkedList<>();
		queue.offer("0000");
		queue.offer(null);

		Set<String> visited = new HashSet<>();
		visited.add("0000");

		int depth = 0;
		while (!queue.isEmpty()) {
			String str = queue.poll();
			if (str == null) {
				depth++;
				if (queue.peek() != null) {
					queue.offer(null);
				}
			} else if (target.equals(str)) {
				return depth;
			} else if (!deadSet.contains(str)) {
				for (int i = 0; i < 4; i++) {
					int digit = str.charAt(i) - '0';
					int digit1 = (digit + 1) % 10;
					int digit2 = (digit + 9) % 10;
					String str1 = str.substring(0, i) + digit1 + str.substring(i + 1);
					String str2 = str.substring(0, i) + digit2 + str.substring(i + 1);
					if (!visited.contains(str1)) {
						visited.add(str1);
						queue.offer(str1);
					}
					if (!visited.contains(str2)) {
						visited.add(str2);
						queue.offer(str2);
					}
				}
			}
		}

		return -1;
	}
}

/*
Time Complexity: O(N^2 * A^N + D) where A is the number of digits in our alphabet, 
N is the number of digits in the lock, and D is the size of deadends. 
We might visit every lock combination, plus we need to instantiate our set dead. 
When we visit every lock combination, we spend O(N^2) time enumerating through and constructing each node.

Space Complexity: O(A^N + D), for the queue and the set dead.
*/