class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        int idx = 0, maxSize = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]%nums[j] == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[i]+1;
                    hash[i] = j;
                }
            }
            if(dp[i] > maxSize){
                maxSize = dp[i];
                idx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while(idx != -1){
            list.add(nums[idx]);
            idx = hash[idx];
        }
        return list;
    }
}