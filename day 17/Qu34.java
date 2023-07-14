//Subarray Sums Divisible by K

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> prevRem = new HashMap<>();
        int count=0;
        int sum=0;
        prevRem.put(0, 1);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int mod = (sum%k + k)%k;

            if(prevRem.containsKey(mod)){
                count+=prevRem.get(mod);
            }

            prevRem.put(mod, prevRem.getOrDefault(mod,0)+1);
        }

        return count;
    }
}
