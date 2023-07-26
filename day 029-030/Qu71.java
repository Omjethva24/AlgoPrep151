//Postorder Traversal


class Solution {
    public void solvePostorder(List<Integer> result, TreeNode root) {
        if(root==null)
            return;
        solvePostorder(result, root.left);
        solvePostorder(result, root.right);
        result.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solvePostorder(result, root);
        return result;
    }
}
