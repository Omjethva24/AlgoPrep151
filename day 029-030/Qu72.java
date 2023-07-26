//Right Side View


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        result.add(root.val);
        while(!q.isEmpty()){
            TreeNode cur = q.remove();
            if(cur==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    result.add(q.peek().val);
                }
            }else{
                if(cur.right!=null){
                    q.add(cur.right);
                }
                if(cur.left!=null){
                    q.add(cur.left);
                }
            }
        }
        return result;
    }
}
