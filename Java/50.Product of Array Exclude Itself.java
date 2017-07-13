public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        int length = A.size();
        long[] pre = new long[length + 1];
        long[] suf = new long[length + 1];
        ArrayList<Long> ans = new ArrayList<>();
        pre[0] = A.get(0);
        suf[length] = 1;
        for(int i = 1; i < length; i ++){
            pre[i] = pre[i - 1] * A.get(i);
        }
        for(int i = length - 1; i >= 0; i --){
            suf[i] = suf[i + 1] * A.get(i);
        }
        for(int i = 0; i < length; i ++){
            if(i == 0){
                ans.add(suf[i + 1]);
            }
            else {
                ans.add(pre[i - 1] * suf[i + 1]);
            }
        }
        return ans;
    }
}

