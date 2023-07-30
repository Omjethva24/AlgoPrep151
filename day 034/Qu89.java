//Maximum XOR of Two Numbers in an Array


class Solution {
      class Node{
        Node zero, one;
        Node(){
            zero=null;
            one=null;
        }
    }
    
    public void insert(int n, Node root){
        Node curr = root;
        for(int i=31; i>=0; i--){
            
            int bit = (n >> i) & 1;
            if(bit == 1){
                if(curr.one==null){
                    curr.one = new Node();
                }
                curr=curr.one;
            }else{
                if(curr.zero==null){
                    curr.zero = new Node();
                }
                curr=curr.zero;
            }
        }
    }
    public int findMaxXor(int n, Node root, int ans){
        Node curr = root;
        for(int i=31; i>=0; i--){
            
            int bit = (n >> i) & 1;
            if(bit == 1){
                if(curr.zero!=null){
                    ans += (1<<i);
                    curr=curr.zero;
                }else{
                    curr=curr.one;
                }
            }else{
                if(curr.one!=null){
                    ans += (1<<i);
                    curr=curr.one;
                }else{
                    curr=curr.zero;
                }
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        int n=nums.length;
        for(int i=0; i<n; i++){
            insert(nums[i], root);
        }
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, findMaxXor(nums[i] , root, 0));
        }
        return max;
    }
}
