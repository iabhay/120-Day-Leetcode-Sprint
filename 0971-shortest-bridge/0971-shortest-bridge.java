import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        // Step 1: Find the first island and mark its cells as visited
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    found = true;
                    break;
                }
            }
        }
        
        // Step 2: Use DFS to find the second island
        for (int i = 0; i < n; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (dfsFindSecondIsland(grid, i, j, visited)) {
                        found = true;
                        break;
                    }
                }
            }
        }
        
        // Step 3: Use BFS to find the shortest path between the islands
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int minFlips = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] direction : directions) {
                    int newRow = curr[0] + direction[0];
                    int newCol = curr[1] + direction[1];
                    
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                        if (grid[newRow][newCol] == 1) {
                            return minFlips;
                        } else {
                            visited[newRow][newCol] = true;
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
            
            minFlips++;
        }
        
        return -1; // No path found
    }
    
    private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        int n = grid.length;
        
        if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        
        visited[row][col] = true;
        grid[row][col] = 2; // Mark as visited and part of the first island
        
        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);
    }
    
    private boolean dfsFindSecondIsland(int[][] grid, int row, int col, boolean[][] visited) {
        int n = grid.length;
        
        if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0) {
            return false;
        }
        
        visited[row][col] = true;
        
        if (grid[row][col] == 1) {
            return true;
        }
        
        return dfsFindSecondIsland(grid, row - 1, col, visited) ||
               dfsFindSecondIsland(grid, row + 1, col, visited) ||
               dfsFindSecondIsland(grid, row, col - 1, visited) ||
               dfsFindSecondIsland(grid, row, col + 1, visited);
    }
}