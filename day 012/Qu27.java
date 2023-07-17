// Single Number III


class Solution {
    public int[] singleNumber(int[] nums) {
    int xorResult = 0;
    for (int num : nums) {
        xorResult ^= num;
    }

    int rightmostSetBit = xorResult & -xorResult;

    int res[] = new int[2];
    for (int num : nums) {
        if ((num & rightmostSetBit) != 0) {
            res[0] ^= num;
        } else {
            res[1] ^= num;
        }
    }

    return res;

    }
}