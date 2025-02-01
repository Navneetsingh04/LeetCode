class Solution {
    public static void permutationHelpher(int nums[],List<List<Integer>> ans,int start){
        if(start == nums.length){
            List<Integer> current = new ArrayList<>();
            for(int n : nums){
                current.add(n);
            }
            ans.add(current);
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = start;i<nums.length;i++){
            // only proceed if the element is not visited
            if(visited.add(nums[i])){
                swap(nums,i,start);
                permutationHelpher(nums,ans,start+1);
                // backtarck
                swap(nums,i,start);
            }
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        permutationHelpher(nums,ans,0);
        return ans;
    }
}