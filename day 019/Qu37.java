//Longest Consecutive Sequence


class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){return 0;}
        TreeSet<Integer> sortNums = new TreeSet<>();
        for(int i : nums){
            sortNums.add(i);
        }

        Object[] arr = sortNums.toArray();
        int count=1,max=1;
        for(int i=0; i<arr.length-1; i++){
            if(((int)arr[i+1]-(int)arr[i])==1){
                count++;
                max=Math.max(max, count);
            }else{
                count=1;
            }
        }

        return max;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){return 0;}
        TreeSet<Integer> sortNums = new TreeSet<>();
        for(int i : nums){
            sortNums.add(i);
        }

        Object[] arr = sortNums.toArray();
        int count=1,max=1;
        for(int i=0; i<arr.length-1; i++){
            if(((int)arr[i+1]-(int)arr[i])==1){
                count++;
                max=Math.max(max, count);
            }else{
                count=1;
            }
        }

        return max;
    }
}
