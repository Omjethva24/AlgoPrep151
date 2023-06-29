// Majority Element II


class Solution {
    public List<Integer> majorityElement(int[] nums) {
         HashMap<Integer, Integer> hash= new HashMap<Integer, Integer>();
         List<Integer> ans= new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(hash.containsKey(nums[i])){
                hash.put(nums[i], hash.get(nums[i])+1);
            }else{
                hash.put(nums[i], 1);
            }
        }

        for(Integer i:hash.keySet()){
            if(hash.get(i) > nums.length/3){
                ans.add(i);
            }
        }
        return ans;
    }
}
