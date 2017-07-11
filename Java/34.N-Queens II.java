class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //write your code here
        boolean[] is = new boolean[n * 5 + 1];
        for(int i = 0; i < n * 5 + 1; i ++){
            is[i] = false;
        }
        return dfs(n, is, 0);
    }
    
    private int dfs(int n, boolean[] is, int x){
        if(n == x){
            return 1;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(can(is, n, x, i)){
                is[i] = true;
                is[n * 2 + x - i] = true;
                is[n * 3 + x + i] = true;
                ans += dfs(n, is, x + 1);
                is[i] = false;
                is[n * 2 + x - i] = false;
                is[n * 3 + x + i] = false;
            }
        }
        return ans;
    }
    
    private boolean can(boolean[] is, int n, int x, int y){
        if(is[y]){
            return false;
        }
        if(is[n * 2 + x - y]){
            return false;
        }
        if(is[n * 3 + x + y]){
            return false;
        }
        return true;
    }
};


