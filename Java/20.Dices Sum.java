public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        double[][] dp = new double[n + 1][6 * n + 1];
        for(int i = 1; i <= 6; i ++){
            dp[1][i] = 1.0 / 6;
        }
        for(int i = 2; i <= n; i ++){
            for(int j = i; j <= 6 * i; j ++){
                for(int k = 1; k <= 6; k++){
                    if(j - k >= 0)
                        dp[i][j] += dp[i - 1][j - k];
                }
                dp[i][j] /= 6;
            }
        }
        List<Map.Entry<Integer, Double>> ans = new ArrayList<Map.Entry<Integer, Double>>();
        for(int i = n; i <= 6 * n; i ++){
            ans.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i]));
        }
        return ans;
    }
}
