class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        List<Integer> list = new ArrayList<>();
        for(int i[] : grid){
            for(int num : i){
                list.add(num);
            }
        }
        Collections.sort(list);
        int target = list.get(list.size()/2);
        int count = 0;
        for(int i : list){
            if(i%x != target%x){
                return -1;
            }
            count += Math.abs(target-i)/x;
        }
        return count;
    }
}