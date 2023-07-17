//Number of Subarrays with Bounded Maximum

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0, si = 0, ei = 0, prev = 0,n = nums.length;
        while(ei<n){
            if(nums[ei]>=left && nums[ei]<=right){
                prev = ei - si +1;
                ans+=prev;
            } else if(nums[ei]<left){
                ans+=prev;
            } else{
                si=ei+1;
                prev=0;
            }
            ei++;
        }
        return ans;
    }
}