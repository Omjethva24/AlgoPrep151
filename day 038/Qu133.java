//Prim's algoritms - MST

class Solution{
    //make pair class which save node and his cost both
    static class Pair implements Comparable<Pair>{
        int n;
        int cost;
        
        Pair(int n, int cost){
            this.n=n;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    //first by 2d array we have to make adj list 
	    ArrayList<ArrayList<Pair>>  list=new ArrayList<ArrayList<Pair>>();
	    
	    for(int i=0; i<V; i++){
            list.add(new ArrayList<Pair>());
	    }
	    
	    for(int i=0; i<E; i++){
	        int u=edges[i][0];
	        int v=edges[i][1];
	        int wt=edges[i][2];
	        //now this graph is undirected so we have to add for both v and u
	        list.get(u).add(new Pair(v, wt));
	        list.get(v).add(new Pair(u, wt));
	    }
	    
	    //everytime we need minumum cost v so we make pq
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    
	    //for track visited or not
	    boolean vis[] = new boolean[V];
	    
	    //for save final cost
	    int finalCost = 0;
	    
	    //first pick any one v and add in pq
	    pq.add(new Pair(0, 0));
	    
	    //now do actual work
	    while(!pq.isEmpty()){
	        Pair curr = pq.remove();
	        
	        //if curr is visited we not visit again 
	        if(!vis[curr.n]){
	            vis[curr.n] = true;
	            finalCost += curr.cost;
	            
	            //now add curr neighbour in pq
	            for(int i=0; i<list.get(curr.n).size(); i++){
	                Pair currPair = list.get(curr.n).get(i);
	                pq.add(new Pair(currPair.n, currPair.cost));
	            }
	        }
	    }
	    return finalCost;
	}
}
