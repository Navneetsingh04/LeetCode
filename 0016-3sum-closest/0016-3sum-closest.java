class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closetSum = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i = 0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            while(left<right){
            int currSum = nums[i]+nums[left]+nums[right];
                if(Math.abs(target-currSum) < Math.abs(target-closetSum)){
                    closetSum = currSum;
                }
                if(currSum < target){
                    left++;
                }
                else if(currSum > target){
                    right--;
                }
                else{
                    return currSum;
                }
            }
        }
        return closetSum;
    }
}