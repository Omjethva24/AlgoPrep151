//Articulation point

class Solution
{
    public void dfs(ArrayList<ArrayList<Integer>> adj, int curr, int par, int dt[], int low[],
                    int time, boolean ap[], boolean vis[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children  = 0;
        
        for(int i=0; i<adj.get(curr).size(); i++){
            int neigh = adj.get(curr).get(i);
            
            if(neigh==par){
                continue;
            }else if(vis[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);
            }else{
                dfs(adj, neigh, curr, dt, low, time, ap, vis);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(par!=-1 && dt[curr]<=low[neigh]){
                    ap[curr] = true;
                }
                children++;
            }
        }
        
        if(par==-1 && children>1){
            ap[curr] = true;
        }
        
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        int time =0;
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(adj, i, -1, dt, low, time, ap, vis);
            }
        }
        
        for(int i=0; i<V; i++){
            if(ap[i]){
                result.add(i);
            }
        }
        if(result.size()==0) result.add(-1);
        return result;
    }
}
