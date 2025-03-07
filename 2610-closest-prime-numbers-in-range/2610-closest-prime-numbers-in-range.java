class Solution {
    public List<Integer> sieveOfEratonsthenes(int right){
        int prime[] = new int[right+1];
        Arrays.fill(prime,1);
        for(int i = 2;i*i<=right;i++){
            if(prime[i] == 1){
                for(int j = 2*i;j<=right;j +=i){
                    prime[j] = 0;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i = 2;i<=right;i++){
            if(prime[i] == 1){
                primes.add(i);
            }
        }
        return primes;
    }
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = sieveOfEratonsthenes(right);

        List<Integer> inRange = new ArrayList<>();
        for(int p : primes){
            if(p >= left && p <= right){
                inRange.add(p);
            }
        }
        if(inRange.size() < 2){
            return new int[]{-1,-1};
        }
        int minDiff = Integer.MAX_VALUE;
        int ans1 = -1,ans2 = -1;
        for(int i = 1;i<inRange.size();i++){
            int diff = inRange.get(i) - inRange.get(i-1);
            if(diff < minDiff){
                minDiff = diff;
                ans1 = inRange.get(i-1);
                ans2 = inRange.get(i);
            }
        }
        return new int[]{ans1,ans2};
    }
}