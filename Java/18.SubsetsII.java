class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        if(nums == null){
            return ans;
        }
        Arrays.sort(nums);
        helper(ans, cur, nums, 0);
        return ans;
    }
    public void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, int[] nums, int depth){
        if(!ans.contains(cur)){
            ans.add(new ArrayList<Integer>(cur));
        }
        for(int i = depth; i < nums.length; i++){
            cur.add(nums[i]);
            helper(ans, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}

