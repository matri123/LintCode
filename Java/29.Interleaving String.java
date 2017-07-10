public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @param : A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return helper(s3, s1, s2, 0, 0, 0);
    }
    
    public boolean helper(String s1, String s2, String s3, int a, int b, int c) {
        if(s1.length() < a || s2.length() < b || s3.length() < c){
            return false;
        }
        if(a == s1.length()) {
            return true;
        }
        if(s2.length() == b){
            if(s1.charAt(a) == s3.charAt(c)) {
                return helper(s1, s2, s3, a + 1, b, c + 1);
            }
            else {
                return false;
            }
        }
        else if(s3.length() == c) {
            if(s2.charAt(b) == s1.charAt(a)) {
                return helper(s1, s2, s3, a + 1, b + 1, c);
            }
            else {
                return false;
            }
        }
        boolean temp = false;
        if(s1.charAt(a) == s3.charAt(c)){
            temp = temp || helper(s1, s2, s3, a + 1, b, c + 1);
        }
        if(s1.charAt(a) == s2.charAt(b)){
            temp = temp || helper(s1, s2, s3, a + 1, b + 1, c);
        }
        return temp;
    }
};
