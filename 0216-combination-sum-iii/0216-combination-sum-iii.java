class Solution {
    public void findCombination(int index,int k,int n,List<Integer> list, List<List<Integer>> ans){
        if(k == 0 && n == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<=9;i++){
            if(i > n) break;
            list.add(i);
            findCombination(i+1,k-1,n-i,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(1,k,n,list,ans);
        return ans;
    }
}