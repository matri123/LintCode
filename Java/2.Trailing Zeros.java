class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long ans = 0;
        long temp = 5;
        while(n / temp >= 1){
            ans += (n / temp);
            temp *= 5;
        }
        return ans;
    }
};

