public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str == null || str.length == 0 || offset == 0){
            return ;
        }
        int length = str.length;
        offset = offset % length;
        char[] temp = new char[length + 1];
        for(int i = length - offset; i < length; i ++){
            temp[i - length + offset] = str[i];
        }
        for(int i = length - 1; i >= offset; i --){
            str[i] = str[i - offset];
        }
        for(int i = 0; i < offset; i ++){
            str[i] = temp[i];
        }
    }
}

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str == null || str.length == 0 || offset == 0){
            return ;
        }
        int length = str.length;
        offset = offset % length;
        reverse(str, 0, length - 1 - offset);
        reverse(str, length - offset, length - 1);
        reverse(str, 0, length - 1);
    }
    public void reverse(char[] str, int start, int end){
        for(int i = start,j = end; i < j; i ++, j --){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
