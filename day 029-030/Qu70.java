//Binary Tree Inorder Traversal
//solve with morris traversal
//i can also solve with recursion but i want learn something new

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      
       TreeNode curr=root;
       List<Integer> ans = new ArrayList<>();
        while(curr!=null){
            if(curr.left==null){
                ans.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode temp = curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=curr;
                    curr=curr.left;
                }else{
                    ans.add(curr.val);
                    temp.right=null;
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}
