//Bellman-Ford Algorithm

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int dis[] = new int[V];
        
        for(int i=0; i<V; i++){
            if(i!=S){
                dis[i]=100000000;
            }
        }
        
        for(int i=0; i<V-1; i++){
            
            for(int j=0; j<edges.size(); j++){
                int u=edges.get(j).get(0);
                int v=edges.get(j).get(1);
                int wt=edges.get(j).get(2);
                
                if(dis[u]!=100000000 && dis[u]+wt <= dis[v]){
                    dis[v]=dis[u]+wt;
                }
            }
        }
        
        //checking there is a cycle or not
        for (int j = 0; j < edges.size(); j++) {
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int wt = edges.get(j).get(2);

            if (dis[u] != 100000000 && dis[u] + wt < dis[v]) {
            }
        }
        return dis;
    }
}

