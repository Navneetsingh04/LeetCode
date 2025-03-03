class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int ans[] = new int[n];
        int left = 0;
        int count = 0;

        for(int num : nums){
            if(num == pivot) count++;
        }
        for(int num : nums){
            if(num < pivot){
                ans[left++] = num;
            }
        }
        for(int i = 0;i<count;i++){
            ans[left++] = pivot;
        }
        for(int num : nums){
            if(num > pivot){
                ans[left++] = num;
            }
        }
        return ans;
    }
}