public class Solution {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length <= 1){
            return ;
        }
        int left = 0, right = chars.length - 1;
        while(left <= right){
            while(left <= right && chars[left] >= 'a' && chars[left] <= 'z'){
                left ++;
            }
            while(left <= right && chars[right] >= 'A' && chars[right] <= 'Z'){
                right --;
            }
            if(left <= right){
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left ++;
                right --;
            }
        }
        Arrays.sort(chars, 0, left);
        if(left < chars.length)
            Arrays.sort(chars, left, chars.length);
    }
}

