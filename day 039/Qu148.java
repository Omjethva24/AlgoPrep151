//Min swaps required to sort array

class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int count=0;
        int n=nums.length;
        int b[]=Arrays.copyOf(nums,n);
        Arrays.sort(b);
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(b[i], i);
        }
        for(int i=0; i<n; i++){
            while(hm.get(nums[i])!=i){
                count++;
                swap(nums, hm.get(nums[i]), i);
            }
        }
        return count;
    }
    static void swap(int []arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}
