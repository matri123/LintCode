public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums.size() == 0){
            return 0;
        }
        int maxsum = 0;
        int presum = 0;
        int ans = nums.get(0);
        for(int i = 0; i < nums.size(); i ++){
            presum += nums.get(i);
            ans = Math.min(ans, presum - maxsum);
            maxsum = Math.max(maxsum, presum);
        }
        return ans;
    }
}

