//Boundry Traversal

class Solution
{
    static void leftBoundry(Node curr, ArrayList<Integer> result){
        if(curr==null){
            return;
        }
        
        if(curr.left != null){
            result.add(curr.data);
            leftBoundry(curr.left, result);
        } else if(curr.right != null){
            result.add(curr.data);
            leftBoundry(curr.right, result);
        }
    }
    static void rightBoundry(Node curr, ArrayList<Integer> result){
        if(curr==null){
            return;
        }
        
        if(curr.right != null){
            rightBoundry(curr.right, result);
            result.add(curr.data);
        } else if(curr.left != null){
            rightBoundry(curr.left, result);
            result.add(curr.data);
        }
    }
    static void leaf(Node curr, ArrayList<Integer> result){
        if(curr==null){
            return;
        }
        if(curr.left==null && curr.right==null){
            result.add(curr.data);
            return;
        }
        leaf(curr.left, result);
        leaf(curr.right, result);
    }
	ArrayList <Integer> boundary(Node node)
	{
	    Node root=node;
	    ArrayList<Integer> result = new ArrayList<>();
	    result.add(root.data);
	    leftBoundry(root.left, result);
	    leaf(root.left, result);
	    leaf(root.right, result);
	    rightBoundry(root.right, result);
	    return result;
	}
}

