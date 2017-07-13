public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int ans = nums.get(0), sum = 1;
        for(int i = 1; i < nums.size(); i ++){
            if(ans == nums.get(i)) {
                sum ++;
            }
            else {
                sum --;
                if(sum <= 0){
                    ans = nums.get(i);
                    sum = 1;
                }
            }
        }
        return ans;
    }
}
