//Frog Jump

class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int a : stones){
            map.put(a, new HashSet<Integer>());
        }

        map.get(stones[0]).add(1);

        for(int i=0; i<stones.length; i++){
            int currStone = stones[i];
            HashSet<Integer> options = map.get(currStone);

            for(int jump : options){
                int position = currStone + jump;

                if(position == stones[stones.length-1]){
                    return true;
                }

                if(map.containsKey(position)){
                    if(jump - 1 > 0){
                        map.get(position).add(jump - 1);
                    }
                    map.get(position).add(jump + 1);
                    map.get(position).add(jump);
                }
                
            }
        }
        return false;
    }
}
