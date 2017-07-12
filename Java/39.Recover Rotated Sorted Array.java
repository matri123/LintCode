public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int mid = nums.size();
        for(int i = 0; i < nums.size() - 2; i++){
            if(nums.get(i) > nums.get(i + 1)){
                mid = i;
                break;
            }
        }
        if(mid == nums.size()){
            return ;
        }
        reverse(nums, 0, mid);
        reverse(nums, mid + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }
    
    private void reverse(ArrayList<Integer> nums, int start, int end){
        for(int i = start, j = end; i < j; i ++, j --){
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}
