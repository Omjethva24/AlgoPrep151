//Maximum AND Value


class Solution{
    
   // Function for finding maximum AND value.
    public static int checkBit (int pattern, int arr[], int N) {
        int count = 0;
        for(int i=0; i<N; i++){
            if((arr[i]&pattern) == pattern){
                count++;
            }
        }
        return count;
    }
    public static int maxAND (int arr[], int N) {
        
        // Your code here
        int res=0,count=0;
        for(int bit=16; bit>=0; bit--){
            count=checkBit((res | 1<<bit), arr, N);
            if(count>=2)
                res |= (1<<bit);
        }
       return res; 
    }
    
}
