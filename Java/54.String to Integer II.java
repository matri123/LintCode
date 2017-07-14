public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if (str == null || str.length() < 1)
            return 0;
        
        str = str.trim();
        char flag = '+';
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        long result = 0;
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if (flag == '-')
            result = -result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return flag == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        
        return (int) result;
    }
}
