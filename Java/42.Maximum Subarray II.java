public class Solution {
    /*
     * @param : A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        if(nums == null || nums.size() <= 1){
            return 0;
        }
        int[] pre = new int[nums.size()];
        int[] back = new int[nums.size()];
        int presum = 0, premin = 0;
        for(int i = 0; i < nums.size(); i ++){
            presum += nums.get(i);
            pre[i] = presum - premin;
            premin = Math.min(premin, presum);
        }
        
        int backsum = 0, backmin = 0;
        for(int i = nums.size() - 1; i >= 0; i --){
            backsum += nums.get(i);
            back[i] = backsum - backmin;
            backmin = Math.min(backmin, backsum);
        }
        
        int ans = nums.get(0) + nums.get(1), max = pre[0];
        for(int i = 0; i < nums.size() - 1; i ++){
            max = Math.max(max, pre[i]);
            ans = Math.max(ans, max + back[i + 1]);
        }
        return ans;
    }
};
