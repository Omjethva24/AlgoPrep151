//Redundant Connection

class Solution {
    public int find(int[] parent,int x){
        if(parent[x]==x){
            return x;
        }

        int temp = find(parent, parent[x]);
        parent[x] = temp;
        return temp;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int par[] = new int[edges.length+1];
        int rank[] = new int[edges.length+1];
        for(int i=1; i<par.length; i++){
            par[i] = i;
            rank[i] = 1;
        }

        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];

            int lu = find(par, u);
            int lv = find(par, v);

            if(lu!=lv){
                if(rank[lu] > rank[lv]){
                    par[lv] = lu;
                } else if(rank[lu] < rank[lv]){
                    par[lu] = lv;
                } else{
                    par[lu] = lv;
                    rank[lv]++;
                }
            }else{
                return edge;
            }
        }

        return new int[2];
    }
}