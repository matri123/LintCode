public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        int length = nums.length;
        int[][] con = new int[k + 1][length + 1];
        int[][] uncon = new int[k + 1][length + 1];
        for(int i = 1; i <= k; i ++){
            con[i][i - 1] = Integer.MIN_VALUE;
            for(int j = i; j <= length; j ++){
                con[i][j] = Math.max(con[i][j - 1], uncon[i - 1][j - 1]) + nums[j - 1];
                if(j == i){
                    uncon[i][j] = con[i][j];
                }
                else {
                    uncon[i][j] = Math.max(uncon[i][j - 1], con[i][j]);
                }
            }
        }
        return uncon[k][length];
    }
}

