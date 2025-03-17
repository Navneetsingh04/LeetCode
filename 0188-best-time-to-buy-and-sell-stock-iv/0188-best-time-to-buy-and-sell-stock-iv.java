class Solution {
    public int maxProfit(int k,int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][k+1];
        
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=1;j++){
                dp[i][j][0] = 0;
            }
        }
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                for(int l = 1;l<=k;l++){
                    if(j == 1){
                        int take = -prices[i]+ dp[i+1][0][l];
                        int notTake = 0+ dp[i+1][1][l];
                        dp[i][j][l] = Math.max(take,notTake);
                    }
                    else{
                        int take = prices[i]+dp[i+1][1][l-1];
                        int notTake = 0+dp[i+1][0][l];
                        dp[i][j][l] = Math.max(take,notTake);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}