//Mother Vertex

class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public void dfs(int vertex, ArrayList<ArrayList<Integer>>adj, boolean vis[]){
        vis[vertex]=true;
        
        for(int i=0; i<adj.get(vertex).size(); i++){
            int curr = adj.get(vertex).get(i);
            if(!vis[curr]){
                dfs(curr, adj, vis);
            }
        }
    }
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean vis[] = new boolean[V];
        int lastvertex = 0;
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                lastvertex=i;
            }
        }
        
        Arrays.fill(vis, false);
        dfs(lastvertex, adj, vis);
        for(int i=0; i<V; i++){
            if(!vis[i]){
                return -1;
            }
        }
        
        return lastvertex;
    }
}
