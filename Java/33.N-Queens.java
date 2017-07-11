class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        boolean[] is = new boolean[5 * n + 1];
        for(int i = 0; i <= 5 * n; i++){
            is[i] = false;
        }
        dfs(ans, new ArrayList<String>(), is, n);
        return ans;
    }
    
    private void dfs(ArrayList<ArrayList<String>> ans, ArrayList<String> solution, boolean[] is, int n) {
        if(solution.size() == n){
            ans.add(new ArrayList<>(solution));
            return ;
        }
        int x = solution.size();
        for(int i = 0; i < n; i ++){
            if(can(is, x, i, n)){
                is[i] = true;
                is[n * 2 + x - i] = true;
                is[n * 3 + x + i] = true;
                solution.add(getString(n, i));
                dfs(ans, solution, is, n);
                is[i] = false;
                is[n * 2 + x - i] = false;
                is[n * 3 + x + i] = false;
                solution.remove(solution.size() - 1);
            }
        }
    }
    
    private boolean can(boolean[] is, int x, int y, int n) {
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
    
    private String getString(int n, int x){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++){
            sb.append('.');
        }
        sb.setCharAt(x, 'Q');
        return sb.toString();
    }
};
