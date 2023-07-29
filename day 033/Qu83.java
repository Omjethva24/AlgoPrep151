//Populating Next Right Pointers in Each Node


class Solution {
    public Node connect(Node root){
        if(root==null){
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
           int size = q.size();
           if(size==0){
               return root;
           }
           while(size>0){
               Node curr = q.remove();
               if(size>1){
                   curr.next=q.peek();
               }

               if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                size--;
           }
        }
       return root;
    }
}