class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums){
            sum = (sum + i)%p;
        }
        int target = sum%p;
        if(target == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int curr = 0;
        map.put(0,-1);
        int result = n;

        for(int j = 0;j<n;j++){
            curr = (curr+nums[j])%p;
            int find = (curr - target+p)%p;
            if(map.containsKey(find)){
                result = Math.min(result,j-map.get(find));
            }
            map.put(curr,j);
        }
        return result == n ? -1: result;
    }
}