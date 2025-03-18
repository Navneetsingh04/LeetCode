class Solution {
    public boolean isNice(int nums[],int i,int j){
        int mask =0;
        for(int k = i;k<=j;k++){
            if((mask & nums[k]) != 0){
                return false;
            }
            mask |= nums[k];
        }
        return true;
    }
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(isNice(nums,i,j)){
                    count = Math.max(count,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return count;
    }
}