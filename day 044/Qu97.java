//Consecutive 1's not allowed

class Solution {
    long countStrings(int n) {
        // code here
        long validzero[] = new long[n+1];
        long validOne[] = new long[n+1];
        
        int mod = 1000000007;
        
        validzero[1] = 1;
        validOne[1] = 1;
        
        for(int i=2; i<=n; i++){
            validzero[i] = (validzero[i-1] + validOne[i-1])%mod;
            validOne[i] = validzero[i-1]%mod;
        }
        
        return (validzero[n]+validOne[n])%mod;
    }
}
