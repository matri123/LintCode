class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            ans.add(cur);
            return ans;
        }
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        for(int i = 0; i < visit.length; i ++){
            visit[i] = false;
        }
        helper(ans, cur, nums, visit);
        return ans;
    }
    public void helper(ArrayList<List<Integer>> ans, ArrayList<Integer> cur, int[] nums, boolean[] visit){
        if(nums.length == cur.size()){
            ans.add(new ArrayList<Integer>(cur));
            return ;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])){
                continue;
            }
            cur.add(nums[i]);
            visit[i] = true;
            helper(ans, cur, nums, visit);
            visit[i] = false;
            cur.remove(cur.size() - 1);
        }
        return ;
    }
}
