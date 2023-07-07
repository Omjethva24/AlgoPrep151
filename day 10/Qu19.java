//Permutation Sequence

class Solution {
    public String getPermutation(int n, int k) {
    String str = "";
    for(int i=1; i<=n; i++){
        str=str+i;
    }
     List<String> res=new  ArrayList<>();
     boolean[] isResIsSizeK={false};
        backtrack(res,str,"",k,isResIsSizeK);
        return res.get(k-1);  
    }
    public void backtrack( List<String> res, String str,String ans,int k,boolean[] isResIsSizeK){
        if(str.length()==0){
            if(res.size()==k){
            isResIsSizeK[0]=true;    
            return;
            }
            res.add(ans);
        }else{
            for(int i=0;i<str.length();i++){
                char curr = str.charAt(i);
               String newsb = str.substring(0,i)+str.substring(i+1);
               if(!isResIsSizeK[0]){
                backtrack(res,newsb,ans+curr,k,isResIsSizeK);
               }
            }
        }
    }
}