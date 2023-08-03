//785. Is Graph Bipartite?


class Solution {
    
    public boolean isBipartiteUtil(int[][] graph, int col[], int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        col[k] = 0;

        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i=0; i<graph[curr].length; i++){
                int temp = graph[curr][i];
                if(col[temp]==col[curr]){
                    return false;
                }else if(col[temp]==-1){
                    col[temp] = (col[curr]==0)?1:0;
                    q.add(temp);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int col[] = new int[n];
        for(int i=0; i<n; i++){
            col[i] = -1;
        }
        for(int i=0; i<n; i++){
            if(col[i]==-1){
                if(!isBipartiteUtil(graph, col, n, i)){
                    return false;
                }
            }
        }
        return true;
    }
}
