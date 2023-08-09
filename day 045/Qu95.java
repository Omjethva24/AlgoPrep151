//Box Stacking

class Solution {
    public static void sortArray(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] box1, int[] box2) {
                return box2[1] * box2[2] - box1[1] * box1[2]; // Compare by base area (width * length)
            }
        });
    }
    
    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        int[][] boxes = new int[3 * n][3];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            boxes[index][0] = height[i];
            boxes[index][1] = Math.max(width[i], length[i]);
            boxes[index][2] = Math.min(width[i], length[i]);
            index++;
            
            // First rotation
            boxes[index][0] = width[i];
            boxes[index][1] = Math.max(height[i], length[i]);
            boxes[index][2] = Math.min(height[i], length[i]);
            index++;
            
            // Second rotation
            boxes[index][0] = length[i];
            boxes[index][1] = Math.max(height[i], width[i]);
            boxes[index][2] = Math.min(height[i], width[i]);
            index++;
        }
        
        sortArray(boxes);
        
        // Initialize an array to store the maximum height ending with each box
        int[] dp = new int[3 * n];
        for (int i = 0; i < 3 * n; i++) {
            dp[i] = boxes[i][0];
        }
        
        // maximum height for each box
        for (int i = 1; i < 3 * n; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[i][1] < boxes[j][1] && boxes[i][2] < boxes[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i][0]);
                }
            }
        }
        
        // Find the maximum height among all boxes
        int maxHeight = 0;
        for (int i = 0; i < 3 * n; i++) {
            maxHeight = Math.max(maxHeight, dp[i]);
        }
        
        return maxHeight;
    }
}