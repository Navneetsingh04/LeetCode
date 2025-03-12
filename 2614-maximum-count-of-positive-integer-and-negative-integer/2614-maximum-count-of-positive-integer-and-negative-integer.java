class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int firstNonNeg = binarySearch(nums,0,n);
        int firstPos = binarySearch(nums,1,n);

        int countNeg = firstNonNeg;
        int countPos = n-firstPos;

        return Math.max(countNeg,countPos);
    }
    public int binarySearch(int nums[],int target,int n){
        int i = 0,j = n;
        while(i<j){
            int mid = i+(j-i)/2;
            if(nums[mid] >= target){
                j = mid;
            }
            else{
                i = mid+1;
            }
        }
        return i;
    }
}