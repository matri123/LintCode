public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int length = nums.length;
        int[] premin = new int[length];
        int[] premax = new int[length];
        int[] sufmin = new int[length];
        int[] sufmax = new int[length];
        int sum = 0, min = 0, max = 0;
        for(int i = 0; i < length; i ++){
            sum += nums[i];
            premin[i] = sum - max;
            premax[i] = sum - min;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        min = 0; max = 0; sum = 0;
        for(int i = length - 1; i >=0 ;i --){
            sum += nums[i];
            sufmin[i] = sum - max;
            sufmax[i] = sum - min;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        int ans = 0;
        max = premax[0]; min = premin[0];
        for(int i = 1; i < length; i ++){
            ans = Math.max(ans, sufmax[i] - min);
            ans = Math.max(ans, -(sufmin[i] - max));
            min = Math.min(min, premin[i]);
            max = Math.max(max, premax[i]);
        }
        return ans;
    }
}


