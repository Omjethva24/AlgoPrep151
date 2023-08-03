//Kahn’s algorithm for Topological Sorting

class Solution
{
    //function to find indegree
    static void findIndeg(ArrayList<ArrayList<Integer>> adj, int indeg[], int V){
        for(int i=0; i<V; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                int curr = adj.get(i).get(j);
                indeg[curr]++;
            }
        }
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int indeg[] = new int[V];
        findIndeg(adj, indeg, V);
        
        int result[] = new int[V];
        int last=0;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.remove();
            result[last++]=curr;
            
            for(int i=0; i<adj.get(curr).size(); i++){
                int temp = adj.get(curr).get(i);
                indeg[temp]--;
                if(indeg[temp]==0){
                    q.add(temp);
                }
            }
        }
        
        return result;
    }
}
