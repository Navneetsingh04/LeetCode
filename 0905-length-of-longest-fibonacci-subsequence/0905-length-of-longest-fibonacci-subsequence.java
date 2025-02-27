class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,2);
        }
        for(int i = 0;i<n;i++){
            map.put(arr[i],i);
        }
        int maxLen = 0;

        for(int j = 1;j<n;j++){
            for(int k = j+1;k<n;k++){
                int target = arr[k] - arr[j];
                if(map.containsKey(target) && map.get(target) < j){
                    int i = map.get(target);
                    dp[j][k] = dp[i][j]+1;
                }
                maxLen = Math.max(maxLen,dp[j][k]);
            }
        }
        return maxLen >= 3 ? maxLen : 0;
    }
}