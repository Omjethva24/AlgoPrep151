//Single Number II


class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0,n=nums.length;
        for(int i=0; i<32; i++){
            int temp=1<<i;
            int countones=0;
            for(int j=0; j<n; j++){
                if((nums[j] & temp)!=0){
                    countones++;
                }
            }
            if(countones % 3==1){
                ans = (ans | temp);
            }
        }  
        return ans;
    }
}
