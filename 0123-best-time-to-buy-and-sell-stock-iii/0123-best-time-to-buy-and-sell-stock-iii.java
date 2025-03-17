class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cap = 2;
        int dp[][][] = new int[n][2][cap+1];
        for(int i[][] : dp){
            for(int row[] : i){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,1,cap,prices,dp,n);
    }
    public int solve(int i,int buy,int cap,int prices[],int dp[][][],int n){
        if(i == n) return 0;
        if(cap == 0) return 0;
        if(dp[i][buy][cap] != -1){
            return dp[i][buy][cap];
        }
        int profit = 0;
        if(buy==1){
            int take = -prices[i]+solve(i+1,0,cap,prices,dp,n);
            int notTake = 0+solve(i+1,1,cap,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        else{
            int take = prices[i]+solve(i+1,1,cap-1,prices,dp,n);
            int notTake = 0+solve(i+1,0,cap,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        return dp[i][buy][cap] = profit;
    }
}