//Range Addition
public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i ++) {
            result[updates[i][0]] += updates[i][2];
            if (updates[i][1] + 1 < length) {
                result[updates[i][1] + 1] -= updates[i][2];
            }
        }
        int curr = 0;
        for (int i = 0; i < result.length; i ++) {
            if (result[i] != 0) {
                curr += result[i];
            }
            result[i] = curr;
        }
        return result;
    }
}
