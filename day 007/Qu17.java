//Find Pair Given Difference
class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        Arrays.sort(arr);
        int left = 0;
        int right = 1;
        while (left < size && right < size) {
            int currentDifference = arr[right] - arr[left];
            if (currentDifference == n) {
                return true;
            } else if (currentDifference < n) {
                right++; 
            } else {
                left++; 
            }
            if (left == right) {
                right++;
            }
        }
        return false;
    }
}
