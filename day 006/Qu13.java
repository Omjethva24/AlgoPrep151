//Minimum Platforms

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
        {
        // add your code here
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platformReq = 1;
        
        int end = 0;
        
        for(int i=1;i<n;i++){
            if(arr[i]>dep[end]){
                end++;
            }else{
                platformReq++;
            }
        }
        return platformReq;
    }
    
}