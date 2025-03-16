class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ahead[] = new int[2];
        int curr[] = new int[2];
        ahead[0] = 0;
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                if(j == 1){
                    int take = -prices[i]+ ahead[0];
                    int notTake = 0+ ahead[1];
                    curr[j] = Math.max(take,notTake);
                }
                else{
                    int take = prices[i]+ ahead[1];
                    int notTake = 0+ahead[0];
                    curr[j] = Math.max(take,notTake);
                }
            }
            ahead = curr.clone();
        }
        return ahead[1];
    }
}