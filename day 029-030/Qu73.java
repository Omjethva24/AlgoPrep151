//Left View of Binary Tree

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        result.add(root.data);
        while(!q.isEmpty()){
            Node cur = q.remove();
            if(cur==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    result.add(q.peek().data);
                }
            }else{
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
        }
        return result;
    }
}
