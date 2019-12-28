package l01_queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/open-the-lock/
 */
class L06OpenTheLock {
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