//Binary Tree to CDLL


class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    
        Node head=null;
        Node tail=null;
        Node prev = null;
    Node bTreeToClist(Node root)
    {
        //your code here
        inorder(root);
        head.left=tail;
        tail.right=head;
        return head;
    }
    void inorder(Node root) {
        if(root == null)
            return;
        
        inorder(root.left);
        
        if(prev != null) {
            root.left = prev;
            prev.right = root;
        }
        else {
            head = root;
        }
        prev = root;
        tail=prev;
        
        inorder(root.right);
    }
    
}
    

