class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int diff = i-nums[i];
            // counting previous postiotn with same difference
            int goodPairs = map.getOrDefault(diff,0);
            count += i-goodPairs;
            map.put(diff,goodPairs+1);
        }
        return count;
    }
}