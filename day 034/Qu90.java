//Maximum XOR With an Element From Array


class Solution {
    class Node{
        Node zero, one;
        Node(){
            zero=null;
            one=null;
        }
    }
    
    public void insert(int n, Node root){
        Node curr = root;
        for(int i=31; i>=0; i--){
            
            int bit = (n >> i) & 1;
            if(bit == 1){
                if(curr.one==null){
                    curr.one = new Node();
                }
                curr=curr.one;
            }else{
                if(curr.zero==null){
                    curr.zero = new Node();
                }
                curr=curr.zero;
            }
        }
    }
    
    //find max Xor
    public int findMaxXor(int n, Node root){
        Node curr = root;
        int ans = 0;
        for(int i=31; i>=0; i--){
            
            int bit = (n >> i) & 1;
            if(bit == 1){
                if(curr.zero!=null){
                    ans += (1<<i);
                    curr=curr.zero;
                }else{
                    curr=curr.one;
                }
            }else{
                if(curr.one!=null){
                    ans += (1<<i);
                    curr=curr.one;
                }else{
                    curr=curr.zero;
                }
            }
        }
        return ans;
    }
    
    //array to list
    public List<List<Integer>> arrayToList(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                row.add(arr[i][j]);
            }
            list.add(row);
        }
        return list;
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int Q = queries.length;
        int N= nums.length;
        int ans[] = new int[Q];
        //convert arr to list to save index after sort
        //because we have to return ans in given order
        List<List<Integer>> list = arrayToList(queries);
        for(int i=0; i<Q; i++){
            list.get(i).add(i);
        }
        
        //sort both
        Arrays.sort(nums);
        Collections.sort(list, Comparator.comparingInt(row -> row.get(1)));
        int lastadd = 0;
        
        Node root = new Node();
        
        for(int i=0; i<Q; i++){
            int max=0;
            while(lastadd<N && nums[lastadd] <=  list.get(i).get(1)  ){
                insert(nums[lastadd], root);
                lastadd++;
            }
            if(root.one==null && root.zero==null){
                ans[list.get(i).get(2)] = -1;
            }else{
               ans[list.get(i).get(2)] = findMaxXor(list.get(i).get(0), root);
            }
        }
        return ans;
    }
}
