//Minimum Number of Refueling Stops

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int end = startFuel, maxDistance = startFuel;

        int stops = 0, j = -1;
        int[] usedStations = new int[stations.length + 1];
        boolean change = true;

        while(change && end < target) {
            change = false;
            j = 0;
            for (int i = 0; i < stations.length; i++) {
                if (stations[i][0] > end) {
                    break;
                }
                if (usedStations[i + 1] == 0 && maxDistance < (end + stations[i][1])) {
                    usedStations[j] = 0;
                    maxDistance = end + stations[i][1];
                    j = i + 1;
                    usedStations[i + 1] = 1;
                    change = true;
                }
            }
            stops++;
            end = maxDistance;
        }
        if (end >= target) {
            return stops;
        } else {
            return -1;
        }
    }
}
