//Delete Node in a BST


class Solution {
    public TreeNode findInorderSuccesser(TreeNode root) {
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }

        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }

            if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }

            TreeNode is = findInorderSuccesser(root.right);
            root.val = is.val;
            root.right = deleteNode(root.right, is.val);
        }

        return root;
    }
}
