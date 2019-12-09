package p01_sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
 * Fruits into Baskets (medium)
 * Given an array of characters where each character represents a fruit tree, you 
 * are given two baskets and your goal is to put maximum number of fruits in each 
 * basket. The only restriction is that each basket can have only one type of fruit.
 */
// https://leetcode.com/problems/fruit-into-baskets/
class A05MaxFruitCountOf2Types {
	public static int findLength(char[] arr) {
		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
		// try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
			// shrink the sliding window, until we are left with '2' fruits in the frequency map
			while (fruitFrequencyMap.size() > 2) {
				fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
				if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
					fruitFrequencyMap.remove(arr[windowStart]);
				}
				windowStart++; // shrink the window
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println("Maximum number of fruits: "
				+ A05MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("Maximum number of fruits: "
				+ A05MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
	}
}

/*
Time Complexity: O(N). The outer for loop runs for all characters and the inner while loop processes each character only once, therefore the time complexity of the algorithm will be O(N+N)O(N+N) which is asymptotically equivalent to O(N)O(N).

Space Complexity: O(1) as there can be a maximum of three types of fruits stored in the frequency map.

Similar Problems: Longest Substring with at most 2 distinct characters
*/
