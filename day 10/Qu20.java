//Combination Sum

class Solution {
    static void solve(int index, int[] candidate,List<List<Integer>> ans,ArrayList<Integer> list, int sum,  int target){
        if(index==candidate.length){
            return;
        }
        if(sum==target){
            ans.add(new ArrayList<Integer>(list));
        }else if(sum >target){
            return;
        }else{
            list.add(candidate[index]);
            solve(index, candidate, ans, list, sum+candidate[index],target);
            list.remove(list.size()-1);
            solve(index+1, candidate, ans, list, sum,target);
          }
    }
    public List<List<Integer>> combinationSum(int[] candidate, int target) {
        Arrays.sort(candidate);
        List<List<Integer>> ans =new ArrayList<List<Integer>>();
        ArrayList<Integer> list =new ArrayList<>();
        solve(0, candidate, ans, list, 0,target);
        return ans;
    }
}