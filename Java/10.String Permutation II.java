public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> ans = new ArrayList<String>();
        char[] c = str.toCharArray();
        Arrays.sort(c);
        ans.add(String.valueOf(c));
        while((c = nextPermutation(c)) != null){
            ans.add(String.valueOf(c));
        }
        return ans;
    }
    private char[] nextPermutation(char[] c){
        int index = -1;
        for(int i = c.length - 1; i > 0; i --){
            if(c[i] > c[i - 1]){
                index = i - 1;
                break;
            }
        }
        if(index == -1){
            return null;
        }
        for(int i = c.length - 1; i >= 0; i--){
            if(c[i] > c[index]){
                char temp = c[i];
                c[i] = c[index];
                c[index] = temp;
                break;
            }
        }
        for(int i = index + 1, j = c.length - 1; i < j; i++, j--){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        return c;
    }
}
