// Permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new  ArrayList<>();
        backtrack(res,nums,0);
        return res;  
    }
    public void backtrack( List<List<Integer>> res, int[] nums, int index){
        if(index==nums.length){
            res.add(toList(nums));
        }
        else{
            for(int i=index;i<nums.length;i++){
                swap(index,i,nums);
                backtrack(res,nums,index+1);
                swap(index,i,nums);
            }
        }
    }
    public List<Integer> toList(int[] nums){
        ArrayList<Integer> l=new ArrayList<>();
        for(int n: nums){
            l.add(n);
        }
        return l;
    }
    public void swap(int m,int n,int[] nums){
        int temp=nums[m];
        nums[m]=nums[n];
        nums[n]=temp;
    }
}
