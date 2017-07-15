public class Solution {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return new int[]{-1, -1};
        }
        int left1 = 0, right1 = A.length - 1;
        int left2 = 0, right2 = A.length - 1;
        int ans1 = 0, ans2 = 0;
        while(left1 + 1 < right1){
            int mid = (left1 + right1) / 2;
            if(A[mid] < target){
                left1 = mid;
            }
            else {
                right1 = mid;
            }
        }
        if(A[left1] == target){
            ans1 = left1;
        }
        else if(A[right1] == target){
            ans1 = right1;
        }
        else {
            return new int[]{-1, -1};
        }
        
        while(left2 + 1 < right2){
            int mid = (left2 + right2) / 2;
            if(A[mid] <= target){
                left2 = mid;
            }
            else {
                right2 = mid;
            }
        }
        if(A[right2] == target){
            ans2 = right2;
        }
        else {
            ans2 = left2;
        }
        return new int[]{ans1, ans2};
    }
}

