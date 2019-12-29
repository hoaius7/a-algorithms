package l01_queue_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
Input:
11000
11000
00100
00011

Output: 3
1: land
0: water
 */
class L07NumberOfIslands {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] {-1, 0},
        new int[] {1, 0},
        new int[] {0, -1},
        new int[] {0, 1}
    );
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int nr = grid.length;
        int nc = grid[0].length;
        int total = 0;
        
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    total++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(r * nc + c);
                    grid[r][c] = '0';
                    
                    while (!queue.isEmpty()) {
                        int pos = queue.poll();
                        int r1 = pos / nc;
                        int c1 = pos % nc;
                        for (int[] direction: DIRECTIONS) {
                            int r2 = r1 + direction[0];
                            int c2 = c1 + direction[1];
                            if (r2 < 0 || c2 < 0 || r2 >=nr || c2 >= nc || grid[r2][c2] == '0') {
                                continue;
                            }
                            grid[r2][c2] = '0';
                            queue.offer(r2 * nc + c2);
                        }
                    }
                }
            }
        }
        
        return total;
    }
    
/*
Time complexity: O(M*N) where M is the number of rows and N is the number of columns.
Space complexity: O(min(M,N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,N). 
*/
    
    public int numIslands_dfs(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int nr = grid.length;
        int nc = grid[0].length;
        int total = 0;
        
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
            	if (grid[r][c] == '1') {
            		total++;
            		dfs(grid, r, c);
            	}
            }
        }
        
        return total;
    }
    
	private void dfs(char[][] grid, int r, int c) {
		int nr = grid.length;
		int nc = grid[0].length;

		if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
			return;
		}

		grid[r][c] = '0';
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
	}
/*
Time complexity:O (M*N) where M is the number of rows and N is the number of columns.
Space complexity : worst case (M*N) in case that the grid map is filled with lands where DFS goes by M*N deep. 
*/
}