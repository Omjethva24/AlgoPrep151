//Binary Tree Cameras


class Solution {
    static int cameras = 0;

    public int Cameras(TreeNode root) {
        if(root==null){
            return 1;
        }

        int left = Cameras(root.left);
        int right = Cameras(root.right);
        if(left==-1 || right==-1){
            cameras++;
            return 0;
        }

        if(left==0 || right==0){
            return 1;
        }

        return -1;
    }
    public int minCameraCover(TreeNode root) {
        cameras=0;
        int result = Cameras(root);
        if(result==-1){
            cameras++;
        }
        return cameras;
    }
}
