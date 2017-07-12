public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        int ans = nums[0], temp = 0;
        for(int i = 0; i < nums.length; i ++){
            temp = Math.max(temp, 0);
            temp += nums[i];
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
