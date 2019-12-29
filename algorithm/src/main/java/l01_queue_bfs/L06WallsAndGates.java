package l01_queue_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
https://leetcode.com/problems/walls-and-gates/
You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall.
0 - A gate.
INF - Infinity means an empty room. Integer.MAX_VALUE.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
  
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
class L06WallsAndGates {
	private static final int EMPTY = Integer.MAX_VALUE;
	private static final int GATE = 0;
	private static final List<int[]> DIRECTIONS = Arrays.asList(
			new int[] {1, 0}, 
			new int[] {-1, 0},
			new int[] {0, 1}, 
			new int[] {0, -1}
	);

	public static void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0) {
			return;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		int m = rooms.length;
		int n = rooms[0].length;
		
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (rooms[row][col] == GATE) {
					queue.add(new int[] {row, col});
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int row = point[0];
			int col = point[1];
			for (int[] direction: DIRECTIONS) {
				int r = row + direction[0];
				int c = col + direction[1];
				if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
					continue;
				}
				rooms[r][c] = rooms[row][col] + 1;
				queue.add(new int[] {r, c});
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] rooms = {
				{EMPTY, -1, GATE, EMPTY},
				{EMPTY, EMPTY, EMPTY, -1},
				{EMPTY, -1, EMPTY, -1},
				{GATE, -1, EMPTY, EMPTY}
		};
		
		wallsAndGates(rooms);
		System.out.println(Arrays.deepToString(rooms));
	}
}
/*
Time complexity : O(mn).

If you are having difficulty to derive the time complexity, start simple.
Let us start with the case with only one gate. 
The breadth-first search takes at most m*n steps to reach all rooms, therefore the time complexity is O(mn). 
But what if you are doing breadth-first search from k gates?
Once we set a room's distance, we are basically marking it as visited, 
which means each room is visited at most once. 
Therefore, the time complexity does not depend on the number of gates and is O(mn).

Space complexity : O(mn). The space complexity depends on the queue's size. We insert at most m*n points into the queue.
*/