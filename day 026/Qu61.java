//Largest Rectangle in Histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int nsr[] = new int[n];
        Stack<Integer> st = new Stack<>();
         for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i]=st.peek();
            }
            st.push(i);
        }
        int nsl[] = new int[n];
        st = new Stack<>();
         for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }
        int maxarea=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int width = (nsr[i]-nsl[i])-1;
            int currArea=heights[i]*width;
            maxarea=Math.max(maxarea, currArea);
        }
        return maxarea;
    }
}
