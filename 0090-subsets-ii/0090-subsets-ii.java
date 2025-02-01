class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backTrack(nums,0,list,ans);
        return ans;
    }
    public static void backTrack(int nums[],int index,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i = index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            backTrack(nums, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
}