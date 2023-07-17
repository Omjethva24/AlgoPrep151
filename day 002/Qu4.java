//Maximum Product Subarray

class Solution {
    public int maxProduct(int[] nums) {
         int maxi = Integer.MIN_VALUE;
        int suffix=1;
        int prefix=1;

        for(int i=0;i<nums.length;i++)
        {
          if(suffix==0)
           suffix=1;
          if(prefix==0)
           prefix=1;
          suffix*=nums[i];
          prefix*=nums[nums.length-i-1];
          maxi=Math.max(Math.max(suffix,prefix),maxi);
        }
        
        return maxi;
    }
}
