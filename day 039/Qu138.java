//Strongly Connected Components (Kosaraju's Algo)

class Solution
{
    //make stack 
    public void makeStack(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean vis[], int curr){
        vis[curr] = true;
        
        for(int i=0; i<adj.get(curr).size(); i++){
            int temp = adj.get(curr).get(i);
            if(!vis[temp]){
                makeStack(adj, st, vis, temp);
            }
        }
        
        st.push(curr);
    }
    
    
    public void findNumCom(ArrayList<ArrayList<Integer>> transpose, boolean vis[], int curr){
        vis[curr] = true;
        
        for(int i=0; i<transpose.get(curr).size(); i++){
            int temp = transpose.get(curr).get(i);
            if(!vis[temp]){
                findNumCom(transpose, vis, temp);
            }
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        //step 1 : make a stack of topology sort
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                makeStack(adj, st, vis, i);
            }
        }
        
        //step 2 : tranpose graph
        
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<V; i++){
            vis[i]=false;
            transpose.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<V; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                int temp = adj.get(i).get(j);
                transpose.get(temp).add(i);
            }
        }
        
        //perform DFS on tranpose graph in order stack
        int result = 0;
        while(!st.isEmpty()){
            int curr = st.pop();
            if(!vis[curr]){
                findNumCom(transpose, vis, curr);
                result++;
            }
        }
        
        return result;
    }
}
