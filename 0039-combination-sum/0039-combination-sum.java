class Solution {
    public void findCombination(int index,int arr[],int target,List<List<Integer>> ans,
    List<Integer> list){
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[index] <= target){
            list.add(arr[index]);
            findCombination(index,arr,target-arr[index],ans,list);
            list.remove(list.size()-1);
        }
        findCombination(index+1,arr,target,ans,list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0,candidates,target,ans,list);
        return ans;
    }
}