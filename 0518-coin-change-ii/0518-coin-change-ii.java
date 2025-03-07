class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        } 
        return solve(n-1,amount,coins,dp);
    }
    public int solve(int index,int amount,int coins[],int dp[][]){
        if(index == 0){
            return (amount % coins[0]) == 0 ? 1: 0;
        }
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int notTake = solve(index-1,amount,coins,dp);
        int take = 0;
        if(coins[index] <= amount){
            take = solve(index,amount-coins[index],coins,dp);
        } 
        return dp[index][amount] = take+notTake;
    }
}