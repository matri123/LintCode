public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.size(); i ++) {
            int temp = nums.get(i);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp) + 1);
            }
            else {
                map.put(temp, 1);
            }
        }
        int ans = 0, sum = 0;
        for(int key : map.keySet()) {
            if(map.get(key) > sum) {
                ans = key;
                sum = map.get(key);
            }
        }
        return ans;
    }
}

