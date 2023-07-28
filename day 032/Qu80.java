//Binary Tree Maximum Path Sum


class Solution {
    static int max = Integer.MIN_VALUE;
    int findpathsum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left =Math.max(0, findpathsum(root.left));
        int right =Math.max(0, findpathsum(root.right));
        max = Math.max(max, root.val+left+right);
        return Math.max(left,right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        findpathsum(root);
        return max;
    }
}
