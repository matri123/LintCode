class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if(source == null || target == null){
            return -1;
        }
        int slength = source.length(), tlength = target.length();
        for(int i = 0; i <= slength - tlength; i ++){
            boolean bool = true;
            for(int j = 0; j < tlength; j ++){
                if(source.charAt(i + j) == target.charAt(j)){
                    continue;
                }
                else {
                    bool = false;
                    break;
                }
            }
            if(bool) {
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if(source == null || target == null){
            return -1;
        }
        int slength = source.length(), tlength = target.length();
        int mod = 0x1fffff, base = 33;
        int shash = 0, thash = 0, temp = 1;
        if(tlength == 0){
            return 0;
        }
        for(int i = 0; i < slength; i ++){
            if(i < tlength){
                thash = ((thash * base + target.charAt(i)) % mod + mod) % mod;
                shash = ((shash * base + source.charAt(i)) % mod + mod) % mod;
                if(i != 0){
                    temp = (temp * base % mod + mod) % mod;
                }
            }
            if(i == tlength - 1){
                if(thash == shash){
                    return 0;
                }
            }
            else if(i >= tlength) {
                int tt = temp * source.charAt(i - tlength) % mod;
                shash = shash - tt;
                shash = ((shash * base + source.charAt(i)) % mod + mod) % mod;
                if(shash == thash){
                    return i - tlength + 1;
                }
            }
        }
        return -1;
    }
}
