class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int subset = 1 << n;
        int sum = 0;
        for(int i = 0;i<subset;i++){ 
            int xorValue = 0;
            for(int j = 0; j < n; j++){ 
                if ((i & (1<<j)) != 0){ 
                    xorValue ^= nums[j];
                }
            }
            sum += xorValue;
        }
        return sum;
    }
}
