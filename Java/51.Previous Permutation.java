public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() <= 1) {
            return nums;
        }
        int temp = -1;
        for(int i = nums.size() - 2; i >= 0; i --) {
            if(nums.get(i) > nums.get(i + 1)) {
                temp = i;
                break;
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(temp == -1){
            for(int i = nums.size() - 1; i >= 0; i--) {
                ans.add(nums.get(i));
            }
        }
        else {
            for(int i = nums.size() - 1; i >= temp + 1; i --){
                if(nums.get(i) < nums.get(temp)) {
                    int num = nums.get(temp);
                    nums.set(temp, nums.get(i));
                    nums.set(i, num);
                    break;
                }
            }
            for(int i = 0; i <= temp; i ++){
                ans.add(nums.get(i));
            }
            for(int i = nums.size() - 1; i >= temp + 1; i --) {
                ans.add(nums.get(i));
            }
        }
        return ans;
    }
}

