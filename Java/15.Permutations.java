class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            ans.add(cur);
            return ans;
        }
        helper(ans, cur, nums);
        return ans;
    }
    public void helper(ArrayList<List<Integer>> ans, ArrayList<Integer> cur, int[] nums){
        if(nums.length == cur.size()){
            ans.add(new ArrayList<Integer>(cur));
            return ;
        }
        for(int i = 0; i < nums.length; i++) {
            if(cur.contains(nums[i])){
                continue;
            }
            cur.add(nums[i]);
            helper(ans, cur, nums);
            cur.remove(cur.size() - 1);
        }
        return ;
    }
}

