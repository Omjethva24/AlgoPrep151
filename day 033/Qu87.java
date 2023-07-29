//Serialize and Deserialize Binary Tree


public class Codec {

    // Encodes a tree to a single string.
    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        preorder(root.left,  sb);
        preorder(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    static int idx=0;

    public TreeNode makebt(String[] s) {
        if(idx>=s.length || s[idx].equals("null")){
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s[idx++]));
        node.left = makebt(s);
        node.right = makebt(s);

        return node;
    }
    public TreeNode deserialize(String data) {
        idx=0;
        String[] s = data.split(","); 
        return makebt(s);
    }

}
