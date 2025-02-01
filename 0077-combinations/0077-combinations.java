class Solution {
    public void findCombination(int index,int n,int k,List<Integer> list,  List<List<Integer>> ans){
        if(k == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<=n;i++){
            list.add(i);
            findCombination(i+1,n,k-1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(1,n,k,list,ans);
        return ans;
    }
}