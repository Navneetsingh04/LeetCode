class Solution {
    public boolean isPossible(int nums[],int mid,int k){
        int house = 0;
        int i = 0;
        while(i < nums.length){
            if(nums[i] <= mid){
                house++;
                i++;
            }
            i++;
        }
        return house >= k;
    }
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for(int num : nums){
            l = Math.min(l,num);
            r = Math.max(r,num);
        }
        int ans = r;
        while(l <= r){
            int mid = l+(r-l)/2;

            if(isPossible(nums,mid,k) == true){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
}