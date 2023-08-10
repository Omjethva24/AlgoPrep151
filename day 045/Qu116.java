//Number of subsequences of the form a^i b^j c^k

class Solution
{
    public int fun(String s)
    {
        // Write your code here
        int n = s.length();
        
        long a=0;
        long ab=0;
        long abc=0;
        
        int m = 1000000007;
        for(int i=0; i<n; i++){
            char curr = s.charAt(i);
            
            if(curr=='a'){
                a = (2 * a + 1)%m;
            }else if(curr=='b'){
                ab = (2 * ab + a)%m;
            }else if(curr=='c'){
                abc = (2 * abc + ab)%m;
            }
        }
        
        return (int)abc;
    }
}