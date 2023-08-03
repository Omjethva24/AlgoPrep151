//Dijkstra Algorithm


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        
        Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int pathes[] = new int[V];
        Arrays.fill(pathes, Integer.MAX_VALUE);

        boolean vis[] = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S, 0));
        pathes[S]=0;

        while(!pq.isEmpty()){

            Pair curr = pq.remove();

            if(!vis[curr.n]){
                vis[curr.n]=true;
                
                //add neighbour update his path
                for(int i=0; i<adj.get(curr.n).size(); i++){
                    int u = curr.n;
                    int v = adj.get(curr.n).get(i).get(0);
                    int wt = adj.get(curr.n).get(i).get(1);
                    
                    if(pathes[u]+wt < pathes[v]){
                        pathes[v] = pathes[u]+wt;
                        pq.add(new Pair(v, pathes[v]));
                    }
                }
            }
        }
        return pathes;
    }
}
