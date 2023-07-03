//Trapping Rain Water
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        int lfmax = 0;
        int rimax = 0;
        for(int i=0; i<n; i++){
            lfmax = Math.max(lfmax, height[i]);
            leftMax[i]=lfmax;
            rimax = Math.max(rimax, height[n-i-1]);
            rightMax[n-i-1]=rimax;
        }
        int ans=0;
        for(int i = 1; i<n-1; i++){
            int currRain =Math.min(leftMax[i],rightMax[i])-height[i];
            if(currRain > 0){
                ans+=currRain;
            }
        }
        return ans;
    }
}
