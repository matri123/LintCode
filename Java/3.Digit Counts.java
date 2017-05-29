class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int ans = 0;
        for(int i = 0; i <= n; i ++){
            if(i == 0 && k == 0){
                ans ++;
                continue;
            }
            int temp = i;
            while(temp != 0){
                int a = temp % 10;
                if(a == k){
                    ans ++;
                }
                temp /= 10;
            }
        }
        return ans;
    }
};


class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int temp = 1, ans = 0;
        if(k == 0 && n == 0){
            ans ++;
        }
        while(n / temp > 0){
            int high = n / temp / 10;
            int cur = n % (temp * 10) / temp;
            int low = n % temp;
            if(high == 0 && k == 0) {
                temp *= 10;
                continue;
            }
            if(cur < k){
                ans += high * temp;
            }
            else if (cur == k){
                ans += high * temp + low + 1;
            }
            else{
                ans += (high + 1) * temp;
            }
            temp *= 10;
        }
        return ans;
    }
};

