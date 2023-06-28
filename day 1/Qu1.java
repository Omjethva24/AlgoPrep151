//  Rotate Array

class Qu1 {
    public void swap(int[] nums, int st, int end){
            int temp=nums[end];
            nums[end]=nums[st];
            nums[st]=temp;
    }
    public void reverse(int[] nums, int st, int end){
        while(st < end){
            swap(nums, st, end);
            st++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k=k % len;
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
    }
}
    
