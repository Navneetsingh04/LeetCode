class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            if(st.isEmpty() || nums[st.peek()] > nums[i]){
                st.push(i);
            }
        }
        int maxWidth = 0;
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                maxWidth = Math.max(maxWidth,i-st.peek());
                st.pop();
            } 
        }
        return maxWidth;
    }
}