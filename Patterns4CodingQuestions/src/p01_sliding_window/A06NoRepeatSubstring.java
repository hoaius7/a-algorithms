package p01_sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Given a string, find the length of the longest substring which has no repeating characters.
 */
class A06NoRepeatSubstring {
	public static int findLength(String str) {
		Set<Character> set = new HashSet<>();

		int left = 0, max = 0;
		for (int right = 0; right < str.length(); right++) {
			char cRight = str.charAt(right);
			while (set.contains(cRight)) {
				char cLeft = str.charAt(left);
				set.remove(cLeft);
				left++;
			}
			set.add(cRight);

			max = Math.max(max, set.size());
		}

		return max;
	}

	public static int findLength01(String str) {
		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> charIndexMap = new HashMap<>();
		// try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			// if the map already contains the 'rightChar', shrink the window from the
			// beginning so that we have only one occurrence of 'rightChar'
			if (charIndexMap.containsKey(rightChar)) {
				// this is tricky; in the current window, we will not have any 'rightChar' after
				// its previous index and if 'windowStart' is already ahead of the last index 
				// of 'rightChar', we'll keep 'windowStart'
				windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
			}
			charIndexMap.put(str.charAt(windowEnd), windowEnd); // insert the 'rightChar' into the map
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + A06NoRepeatSubstring.findLength("aabccbb"));
		System.out.println("Length of the longest substring: " + A06NoRepeatSubstring.findLength("abbbb"));
		System.out.println("Length of the longest substring: " + A06NoRepeatSubstring.findLength("abccde"));
		System.out.println("Length of the longest substring: " + A06NoRepeatSubstring.findLength01("aabccbb"));
		System.out.println("Length of the longest substring: " + A06NoRepeatSubstring.findLength01("abbbb"));
		System.out.println("Length of the longest substring: " + A06NoRepeatSubstring.findLength01("abccde"));
	}
}
