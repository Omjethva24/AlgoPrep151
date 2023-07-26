//Binary Tree Preorder Traversal
//solve by morris traversal
//i can also solve with recursion but i want learn something new

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                result.add(cur.val);
                cur=cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=cur;
                    result.add(cur.val);
                    cur=cur.left;
                }else{
                    pre.right=null;
                    cur=cur.right;
                }
            }
        }
        return result;
    }
}
