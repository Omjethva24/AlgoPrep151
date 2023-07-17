//Insert Delete GetRandom O(1) - Duplicates allowed


class RandomizedCollection {
    ArrayList<Integer> list;
    public RandomizedCollection() {
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(list.contains(val)){
            list.add(val);
            return false;
        }
            list.add(val);
            return true;
    }
    
    public boolean remove(int val) {
        if(list.contains(val)){
            list.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int r=(int)(Math.random()*list.size());
       return list.get(r);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
