class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        dp[n][0] = 0;
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                if(j == 1){
                    int take = -prices[i]+ dp[i+1][0];
                    int notTake = 0+ dp[i+1][1];
                    dp[i][j] = Math.max(take,notTake);
                }
                else{
                    int take = prices[i]+ dp[i+1][1];
                    int notTake = 0+dp[i+1][0];
                    dp[i][j] = Math.max(take,notTake);
                }
            }
        }
        return dp[0][1];
    }
}