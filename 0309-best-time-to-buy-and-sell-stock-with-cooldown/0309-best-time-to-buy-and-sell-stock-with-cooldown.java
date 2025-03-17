class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int i[] :  dp){
            Arrays.fill(i,-1);
        }
        return solve(0,1,prices,dp,n);
    }
    public int solve(int i,int buy,int prices[],int dp[][],int n){
        if(i >= n) return 0;
        int profit = 0;
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        if(buy == 1){
            int take = -prices[i]+solve(i+1,0,prices,dp,n);
            int notTake = 0+solve(i+1,1,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        else{
            int take = prices[i]+solve(i+2,1,prices,dp,n);
            int notTake = 0+solve(i+1,0,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        return dp[i][buy] = profit;
    }
}