class Solution {
    public int search(int[] nums, int target) {
        int pivot=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[i-1]){
                pivot=i;
            }
        }
        int l,r;
        if(target>nums[nums.length-1]){
            l=0;
            r=pivot-1;
        }else{
            l=pivot;
            r=nums.length-1;
        }

        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                l=mid+1;
            }else if(target<nums[mid]){
                r=mid-1;
            }
        }

        return -1;
    }
}
