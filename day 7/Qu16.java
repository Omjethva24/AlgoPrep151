//Key pair
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
       HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();
    	for (int i = 0; i < n; i++) {
    		int numberToFind = x - arr[i];
    		if (hash.containsKey(numberToFind)) {
    		    return true;
    		}
    		hash.put(arr[i],i);
    	}
    	return false;
    }
}