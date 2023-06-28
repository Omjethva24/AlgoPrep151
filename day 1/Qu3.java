//problem : Maximum Subarray
//solution in Kadane's algoridhms

class Qu3 {
    //check for all negative or not
    public boolean isAllareNegative(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=0){
                count++;
            }
        }
        return count==0;
    }

    //func for max sub arr
    public int maxSubArray(int[] nums) {

       if(isAllareNegative(nums)){
           int max= Integer.MIN_VALUE;
           for(int i=0; i<nums.length; i++){
             max=Math.max(max, nums[i]);
            }
        return max;
        }
       
        //if not all negative
       int currSum = 0;
       int maxSum = Integer.MIN_VALUE;

       for(int i=0; i<nums.length; i++){
           currSum += nums[i];
            if(currSum < 0){
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
       }
       return maxSum;
    }
}
