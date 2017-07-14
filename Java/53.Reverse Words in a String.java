public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strings.length - 1; i >= 0; i --){
            sb.append(strings[i]);
            if(i != 0){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}

