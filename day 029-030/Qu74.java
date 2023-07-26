//Top View of Binary Tree


class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
    static class Info{
        Node node;
        int hd;
        Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        if(root==null){
            return result;
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));
        q.add(null);
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;
        int min = 0;
        int max = 0;
        while(!q.isEmpty()){
            Info cur = q.remove();
            if(cur==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(cur.hd)){
                    map.put(cur.hd, cur.node);
                }
                if(cur.node.left!=null){
                    q.add(new Info(cur.node.left, cur.hd-1));
                    min = Math.min(min, cur.hd-1);
                }
                if(cur.node.right!=null){
                    q.add(new Info(cur.node.right, cur.hd+1));
                    max = Math.max(max, cur.hd+1);
                }
            }
        }
        for(int i=min; i<=max; i++){
            result.add(map.get(i).data);
        }
        return result;
        
    }
}
