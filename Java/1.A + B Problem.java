class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        while(b != 0){
            int a1 = a ^ b;
            int b1 = (a & b) << 1;
            a = a1;
            b = b1;
        }
        return a;
    }
};
