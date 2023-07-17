//Minimum Cost of ropes
//stick pro. is in leetcode premium so
// i solve this n ropes from gfg

class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        PriorityQueue<Long> rope = new PriorityQueue<>();
        long totCost = 0;
        for(long i : arr){
            rope.add(i);
        }
        
        while(rope.size()!=1){
            long cost = rope.poll()+rope.poll();
            totCost+=cost;
            rope.add(cost);
        }
        
        return totCost;
    }
}
