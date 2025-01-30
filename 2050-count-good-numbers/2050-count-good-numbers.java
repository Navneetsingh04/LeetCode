class Solution {
    long modPow(long x, long n) {
        long res = 1;
        long mod = (long)(1e9 + 7);
        while(n>0){
            if((n & 1) == 1){
                res = (res*x)%mod;
            }
            n = n/2;
            x = (x*x)%mod;
        }
        return res;
    }
    public int countGoodNumbers(long n) {
        long mod = (long)(1e9 + 7);
        long even, odd;

        // Determine the count of even and odd positions
        if((n&1) == 1){
            even = (n/2)+1;
            odd = n/2;
        } 
        else{
            even = odd = n/2;
        }
        // Applying modulo at each step to prevent overflow
        long evenPower = modPow(5,even);
        long oddPower = modPow(4,odd);
        return (int)((evenPower * oddPower) % mod);
    }
}
