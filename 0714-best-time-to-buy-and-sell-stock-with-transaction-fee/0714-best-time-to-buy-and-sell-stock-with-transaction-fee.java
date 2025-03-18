class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        dp[n][1] = 0;
        for(int i= n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                if(buy == 1){
                    int take = -prices[i]+ dp[i+1][0];
                    int notTake = 0+dp[i+1][1];
                    dp[i][buy] = Math.max(take,notTake);
                }
                else{
                    int sellProfit = prices[i]-fee + dp[i+1][1];
                    int notSell = 0+dp[i+1][0];
                    dp[i][buy] = Math.max(sellProfit,notSell);
                }
            }
        }
        return dp[0][1];
    }
}