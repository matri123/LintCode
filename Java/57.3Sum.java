public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numbers.length - 2; i ++){
            if(i > 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            helper(ans, numbers, -numbers[i], i + 1, numbers.length - 1);
        }
        return ans;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> ans, int[] num, int target, int left, int right) {
        while(left < right){
            if(num[left] + num[right] == target){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(num[left]);
                temp.add(num[right]);
                ans.add(temp);
                
                left ++;
                right --;
                while(left < right && num[left - 1] == num[left]){
                    left ++;
                }
                while(left < right && num[right + 1] == num[right]){
                    right --;
                }
            }
            else if(num[left] + num[right] > target){
                right --;
            }
            else {
                left ++;
            }
        }
    }
}
