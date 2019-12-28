package l01_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * https://leetcode.com/problems/walls-and-gates/
 */
class L04WallsAndGates {
	private static final int EMPTY = Integer.MAX_VALUE;
	private static final int GATE = 0;
	private static final List<int[]> DIRECTIONS = Arrays.asList(
			new int[] { 1, 0 }, 
			new int[] { -1, 0 },
			new int[] { 0, 1 }, 
			new int[] { 0, -1 }
	);

	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0) {
			return;
		}
		
		int m = rooms.length;
		int n = rooms[0].length;
		Queue<int[]> q = new LinkedList<>();
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (rooms[row][col] == GATE) {
					q.add(new int[] { row, col });
				}
			}
		}
		while (!q.isEmpty()) {
			int[] point = q.poll();
			int row = point[0];
			int col = point[1];
			for (int[] direction : DIRECTIONS) {
				int r = row + direction[0];
				int c = col + direction[1];
				if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
					continue;
				}
				rooms[r][c] = rooms[row][col] + 1;
				q.add(new int[] { r, c });
			}
		}
	}
}
