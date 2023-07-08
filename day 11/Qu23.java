//N-Queens


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        String temp="";
        for(int i=0; i<n; i++){
           temp+=".";
        }
        for(int i=0; i<n; i++){
           list.add(temp);
        }
        backtrack(0, ans, list, n);
        return ans;
    }

    public void backtrack(int r,  List<List<String>> ans,List<String> list, int n){
        //base case
        if(r==n){
            ans.add(new ArrayList<String>(list));
            return;
        }

        for(int i=0; i<n; i++){
            if(r==0 || isSafe(r-1, i, list, n)){
               list.set(r,list.get(r).substring(0,i)+"Q"+list.get(r).substring(i+1));
                backtrack(r+1, ans, list, n);
                list.set(r,list.get(r).substring(0,i)+"."+list.get(r).substring(i+1));
            }
        }
    }

    public boolean isSafe(int r, int c, List<String> list, int n){
       
        int i=r;
        int j=c;
        while(i>=0){
            if(list.get(i--).charAt(j)=='Q'){
                return false;
            }
        }
        i=r;
        j=c-1;
        while(i>=0 && j>=0){
            if(list.get(i--).charAt(j--)=='Q'){
                return false;
            }
        }
        i=r;
        j=c+1;
        while(i>=0 && j<n){
            if(list.get(i--).charAt(j++)=='Q'){
                return false;
            }
        }
        return true;
    }
}