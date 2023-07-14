//Subarray Sum Equals K

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        int count=0;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(sum==k){
                count++;
            }

            if(prevSum.containsKey(sum-k)){
                count+=prevSum.get(sum-k);
            }

            prevSum.put(sum, prevSum.getOrDefault(sum,0)+1);
        }

        return count;
    }
}
