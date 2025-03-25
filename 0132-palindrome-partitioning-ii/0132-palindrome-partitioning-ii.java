class Solution {
    public boolean isPalindrome(String s){
        int n = s.length();
        int l = 0;
        int r = n-1;
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
    public int solve(int i,String s,int n,int dp[]){
        int minCost = Integer.MAX_VALUE;
        if(i == n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int j = i;j<n;j++){
            sb.append(s.charAt(j));
            if(isPalindrome(sb.toString())){
                int cost = 1+solve(j+1,s,n,dp);
                minCost = Math.min(minCost,cost);
            }
        }
        return dp[i] = minCost;
    }
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,n,dp)-1;
    }
}