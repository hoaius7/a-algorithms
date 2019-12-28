package p02_two_pointers;

/**
 * Remove Duplicates (easy)
 * 
 * Given an array of sorted numbers, remove all duplicates from it. 
 * You should not use any extra space; after removing 
 * the duplicates in-place return the new length of the array.
 */
class A02RemoveDuplicates {
	public static int remove(int[] arr) {
//		int p1 = 0, p2 = 0;
//
//		while (p2 < arr.length) {
//			if (arr[p2] == arr[p1]) {
//				p2++;
//			} else {
//				p1++;
//				arr[p1] = arr[p2];
//			}
//		}
//
//		return p1 + 1;		
		
		int nextNonDuplicate = 1; // index of the next non-duplicate element
		for (int i = 1; i < arr.length; i++) {
			if (arr[nextNonDuplicate - 1] != arr[i]) {
				arr[nextNonDuplicate++] = arr[i];
			}
		}

		return nextNonDuplicate;
	}
	
	/**
	 * Similar Questions: Given an unsorted array of numbers and a target ‘key’, 
	 * remove all instances of ‘key’ in-place and return the new length of the array.
	 */
	public static int remove(int[] arr, int key) {
		int nextElement = 0; // index of the next element which is not 'key'
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != key) {
				arr[nextElement++] = arr[i];
			}
		}

		return nextElement;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
		System.out.println(A02RemoveDuplicates.remove(arr));

		arr = new int[] { 2, 2, 2, 11 };
		System.out.println(A02RemoveDuplicates.remove(arr));
		
	    arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
	    System.out.println(A02RemoveDuplicates.remove(arr, 3));

	    arr = new int[] { 2, 11, 2, 2, 1 };
	    System.out.println(A02RemoveDuplicates.remove(arr, 2));		
	}
}

// Time Complexity: O(N)
// Space Complexity: O(1)