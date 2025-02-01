class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int totalNumber = 1<<n;
        for(int i = 0;i<totalNumber;i++){
            int grayCodeNum = i^(i>>1);
            list.add(grayCodeNum);
        }
        return list;
    }
}