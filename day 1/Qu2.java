//Squares of a Sorted Array
//also we do this by sort method but its TC is O(n*logn)
//ans this solution is in O(n)

class Qu2 {
    public int[] sortedSquares(int[] nums) {
       int i = 0;
       int j = nums.length -1;
       int n = nums.length -1;

       int squares[] = new int[nums.length];

       while(i <= j){
           int a = (int)Math.pow(nums[i],2);
           int b = (int)Math.pow(nums[j],2);
           if(a > b){
               squares[n] = a;
               i++;
           }else{
               squares[n] = b;
               j--;
           }

           n--;
       } 

       return squares;
    }
}
