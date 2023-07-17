//Subarrays with equal 1s and 0s

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> freq = new HashMap<>();
        int ans = 0,sum=0;
        freq.put(0, 1);
        
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                sum--;
            }else{
                sum++;
            }
            ans+=freq.getOrDefault(sum,0);
            freq.put(sum, freq.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}
