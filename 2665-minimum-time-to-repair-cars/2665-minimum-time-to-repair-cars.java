class Solution {
    public long repairCars(int[] ranks, int cars) {
        int maxRank = Integer.MIN_VALUE;
        for(int num : ranks){
            maxRank = Math.max(maxRank,num);
        }
        long l = 1;
        long r = (long)maxRank*cars*cars;
        long ans = -1;

        while(l<=r){
            long mid = l+(r-l)/2;
            if(isPossible(ranks,mid,cars)){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int ranks[],long mid,int cars){
        long carFix = 0;
        for(int i = 0;i<ranks.length;i++){
            carFix += (long)Math.sqrt(mid/ranks[i]);
        }
        return carFix >= cars;
    }
}