//Diagonal Traversal

class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            Node curr=q.remove();
            while (curr!=null)
            {
                if(curr.left!=null)
                    q.add(curr.left);
                result.add(curr.data);
                curr=curr.right;
            }
        }  
        return result;
      }
}