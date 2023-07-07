//Combination Sum II


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combination2( 0,candidates, target, res, list);
        return res;
    }
    public void combination2(int index, int[] arr, int target, List<List<Integer>> res, List<Integer> list){
        if(target == 0){
            Collections.sort(list);
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i < arr.length;i++){
            if(i > index && arr[i] == arr[i - 1]) continue;
            if(target < arr[i]) break;

            list.add(arr[i]);
            combination2(i + 1, arr, target - arr[i], res, list);
            list.remove(list.size() - 1);
        }
    }
}
