//Brick Wall

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hm= new HashMap<>();
        int max = 0;
        for(int i=0; i<wall.size(); i++){
            int sum = 0;
            for(int j=0; j<wall.get(i).size()-1; j++){
                sum+=wall.get(i).get(j);
                hm.put(sum, hm.getOrDefault(sum,0)+1);
                max = Math.max(max,hm.getOrDefault(sum, 0));
            }
        }

        return wall.size()-max;
    }
}
