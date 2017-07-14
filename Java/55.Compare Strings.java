public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        int[] a = new int[100];
        for(int i = 0; i < 99; i++){
            a[i] = 0;
        }
        for(int i = 0; i < A.length(); i++){
            a[A.charAt(i) - 'A'] ++;
        }
        for(int i = 0;i < B.length(); i++){
            if(a[B.charAt(i) - 'A'] > 0){
                a[B.charAt(i) - 'A'] --;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
