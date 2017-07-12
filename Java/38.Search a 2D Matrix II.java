public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int ans = 0, r = 0, c = matrix[0].length - 1;
        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target){
                ans ++;
                r ++;
                c --;
            }
            else if(matrix[r][c] < target){
                r ++;
            }
            else {
                c --;
            }
        }
        return ans;
    }
}

