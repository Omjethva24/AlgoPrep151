//remove max number of edges to keep graph traversal


class Solution {
   public int maxNumEdgesToRemove(int n, int[][] edges) {
    if (edges.length < n - 1) return -1; 

    int[] parAlice = new int[n + 1];
    for (int i = 0; i < parAlice.length; i++) {
      parAlice[i] = i;
    }

    // type 3 nodes
    int numType3Edges = 0;
    for (int[] edge : edges) {
      if (edge[0] == 3) {
        if (union(parAlice, edge[1], edge[2])) {
          numType3Edges++;
        }
      }
    }

    int[] parBob = parAlice.clone(); 

    // Alice
    int numType1Edges = 0;
    for (int[] edge : edges) {
      if (edge[0] == 1) {
        if (union(parAlice, edge[1], edge[2])) {
          numType1Edges++;
        }
      }
    }
    if (numType1Edges + numType3Edges + 1 != n) return -1; 

    // Bob
    int numType2Edges = 0;
    for (int[] edge : edges) {
      if (edge[0] == 2) {
        if (union(parBob, edge[1], edge[2])) {
          numType2Edges++;
        }
      }
    }
    if (numType2Edges + numType3Edges + 1 != n) return -1; 
    return edges.length - numType1Edges - numType2Edges - numType3Edges;
  }

  boolean union(int[] par, int left, int right) {
    int leftpar = find(par, left);
    int rightpar = find(par, right);
    if (leftpar == rightpar) return false;
    par[rightpar] = leftpar;
    return true;
  }
  
  int find(int[] par, int node) {
    if (par[node] != node) {
      par[node] = find(par, par[node]);
    }
    return par[node];
  }

}