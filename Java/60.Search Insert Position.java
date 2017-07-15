public class Solution {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int left = 0, right = A.length - 1;
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(A[mid] == target){
                return mid;
            }
            else if(A[mid] < target){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if(A[left] >= target){
            return left;
        }
        else if(A[left] < target && target <= A[right]){
            return right;
        }
        else {
            return right + 1;
        }
    }
}

