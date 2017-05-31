class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int[] ans = new int[A.length + B.length];
        int a = 0, b = 0, temp = 0;
        while(a != A.length && b != B.length) {
            if(A[a] > B[b]){
                ans[temp] = B[b];
                b ++;
            }
            else {
                ans[temp] = A[a];
                a ++;
            }
            temp ++;
        }
        if(a != A.length){
            while(a != A.length){
                ans[temp] = A[a];
                temp ++;
                a ++;
            }
        }
        else {
            while(b != B.length){
                ans[temp] = B[b];
                temp ++;
                b ++;
            }
        }
        return ans;
    }
}
