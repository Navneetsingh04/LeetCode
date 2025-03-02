class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int dp[][] = new int[n+1][m+1];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == 1){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
                    ans += dp[i+1][j+1];
                }
            }
        }
        return ans;
    }
}