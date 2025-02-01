class Solution {
    public void findCombination(int index,int arr[],int target,List<Integer> list,List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<arr.length;i++){
            if(i>index && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i] > target) break;
            list.add(arr[i]);
            findCombination(i+1,arr,target-arr[i],list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0,candidates,target,list,ans);
        return ans;
    }
}