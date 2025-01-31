class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums2){
            while(!st.isEmpty() && st.peek()<i){
                map.put(st.pop(),i);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            map.put(st.pop(),-1);
        }
        int ans[] = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}