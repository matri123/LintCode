class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if(nums[left] == target){
            return left;
        }
        if(nums[right] == target){
            return right;
        }
        return -1;
    }
}
