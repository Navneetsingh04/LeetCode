class Solution {
    public final int[] directions = {-1,0,1};
    public int dfs(int row, int col, int[][] grid, int[][] dp) {
        int rows = grid.length, cols = grid[0].length;
        if (dp[row][col] != -1) return dp[row][col];
        int maxSteps = 0;
        for (int dir : directions) {
            int newRow = row + dir, newCol = col + 1;
            if (newRow >= 0 && newRow < rows && newCol < cols && grid[row][col] < grid[newRow][newCol]) {
                maxSteps = Math.max(maxSteps, 1 + dfs(newRow, newCol, grid, dp));
            }
        }
        dp[row][col] = maxSteps;
        return maxSteps;
    }
    public int maxMoves(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int maxSteps = 0;
        for (int i = 0; i < rows; i++) {
            maxSteps = Math.max(maxSteps, dfs(i, 0, grid, dp));
        }
        return maxSteps;
    }
}
