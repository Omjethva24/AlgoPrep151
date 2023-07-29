//Construct Binary Tree from Preorder and Inorder Traversal


class Solution {
    static int index = 0;
    public int findposition(int[] inorder, int ele, int n){
        for(int i=0; i<n; i++){
            if(inorder[i]==ele){
                return i;
            }
        }
        return -1;
    }
    public TreeNode solve(int[] preorder, int[] inorder, int inorderstart, int inorderend, int n) {
        if(index >= n || inorderstart > inorderend){
            return null;
        }

        int element = preorder[index++];
        TreeNode temp = new TreeNode(element);
        int pos = findposition(inorder, element, n);

        temp.left = solve(preorder, inorder, inorderstart, pos-1, n);
        temp.right = solve(preorder, inorder, pos+1, inorderend, n);

        return temp;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=0;
        int n=preorder.length;
        return solve(preorder, inorder, 0, n-1, n);
    }
}