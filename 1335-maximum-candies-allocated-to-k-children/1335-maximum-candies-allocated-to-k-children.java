class Solution {
    public int maximumCandies(int[] candies, long k) {
        if(k == 0) return 0;
        int l = 1,r = 0;
        for(int i : candies){
            r = Math.max(r,i);
        }
        int ans = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            long childrenServed = 0;
            for(int i: candies){
                childrenServed += i/mid;
            }
            if(childrenServed >= k){
                ans = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }
}