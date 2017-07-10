public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        String ans = "";
        int length = source.length() + 1, temp = target.length();
        int[] sum = new int[130];
        boolean[] have = new boolean[130];
        for(int i = 0; i < 130; i ++){
            sum[i] = 0;
            have[i] = false;
        }
        for(int i = 0; i < target.length(); i ++){
            char c = target.charAt(i);
            sum[c] ++;
            have[c] = true;
        }
        int front = 0;
        for(int i = 0; i < source.length(); i ++){
            sum[source.charAt(i)] --;
            if(check(sum, have)){
                if(i - front + 1 < length){
                    length = i - front + 1;
                    ans = source.substring(front, i + 1);
                }
                while(check(sum, have)){
                    if(i - front + 1 < length){
                        length = i - front + 1;
                        ans = source.substring(front, i + 1);
                    }
                    sum[source.charAt(front)] ++;
                    front ++;
                }
            }
        }
        return ans;
    }
    
    public boolean check(int[] sum, boolean[] have) {
        for(int i = 0; i < 130; i ++){
            if(have[i] && sum[i] > 0){
                return false;
            }
        }
        return true;
    }
}
