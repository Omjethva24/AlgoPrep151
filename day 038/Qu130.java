//994. Rotting Oranges


class Solution {
   class Pair{
       int r;
       int c;
       Pair(int i, int j){
           r=i;
           c=j;
       }
   }

   public boolean isValid(int x, int y, int n, int m, int[][] grid){
       if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
           return true;
       }
       return false;
   }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int time = 0;
        int fresh = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                   q.add(new Pair(i, j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;

        while(!q.isEmpty()){
            int size = q.size();
            int temp = 0;

            while(size!=0){
                Pair curr = q.remove();
                int xd = curr.r;
                int yd = curr.c;

                int ax[] = new int[]{1, -1, 0, 0};
                int ay[] = new int[]{0, 0 , 1, -1};

                for(int i=0; i<4; i++){
                    int x = ax[i] + xd;
                    int y = ay[i] + yd;

                    if(isValid(x, y, n, m, grid)){
                        temp++;
                        grid[x][y]=2;
                        q.add(new Pair(x,y));
                    }
                }
                size--;
            }
            if(temp!=0) time++;
        }
    for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                  time=0;
                  break;
                }
            }
        }
        return time==0 ? -1 : time;
    }
}
