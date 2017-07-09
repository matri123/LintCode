public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n - 1;
        while(l + 1 < r){
            int mid = (l + r) / 2;
            if(matrix[mid][0] == target){
                return true;
            }
            else if(matrix[mid][0] < target){
                l = mid;
            }
            else {
                r = mid;
            }
        }
        int ll = 0, rr = m - 1, num = 0;
        if(matrix[r][0] < target){
            num = r;
        }
        else {
            num = l;
        }
        //System.out.println("a");
        while(ll + 1 < rr){
            int mid = (ll + rr) / 2;
            if(matrix[num][mid] == target){
                return true;
            }
            else if(matrix[num][mid] < target){
                ll = mid;
            }
            else {
                rr = mid;
            }
        }
        if(matrix[num][rr] == target || matrix[num][ll] == target){
            return true;
        }
        return false;
    }
}

