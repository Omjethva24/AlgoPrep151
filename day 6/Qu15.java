//Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int st=0;
        int en=n-1;
        int max=0;
        while(st<en){
            int currWater=Math.min(height[st],height[en])*(en-st);
            max=Math.max(max, currWater);
            if(height[st]>height[en]){
                en--;
            }else{
                st++;
            }
        }
        return max;
    }
}
