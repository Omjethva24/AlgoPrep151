//Russian Doll Envelopes

//its hard
//varition ofLIC

class Solution {
    public static void sortArray(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] == person2[0]) {
                    // If weights are the same, sort by height in descending order.
                    return person2[1] - person1[1];
                } else {
                    // Sort by weight in ascending order.
                    return person1[0] - person2[0];
                }
            }
        });
    }


    public int lowerBound(ArrayList<int[]> list, int target) {
        int left = 0, right = list.size() - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid)[1] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        sortArray(envelopes);

        ArrayList<int[]> lis = new ArrayList<>();
        lis.add(envelopes[0]);

        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > lis.get(lis.size() - 1)[1]) {
                lis.add(envelopes[i]);
            } else {
                int index = lowerBound(lis, envelopes[i][1]);
                lis.set(index, envelopes[i]);
            }
        }

        return lis.size();
    }
}
