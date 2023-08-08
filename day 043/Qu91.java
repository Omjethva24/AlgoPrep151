//Longest Increasing Subsequence

class Solution {
    public int lcs(int arr1[], int arr2[], int n, int m){
        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        int sortNums[] = new int[set.size()];
        int index = 0;
        for(int a : set){
            sortNums[index++] = a;
        }

        Arrays.sort(sortNums);
        int n = nums.length;
        int m = sortNums.length;
        return lcs(nums, sortNums, n, m);
    }
}

