class Solution {
    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i<n-2;i++){
            for(int j = 0;j<m-2;j++){
                int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2]    // Top row
                        + grid[i+1][j+1]                              // Middle element
                        + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];  //last row
                 maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}