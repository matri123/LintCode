public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length < 3){
            return 0;
        }
        Arrays.sort(numbers);
        int ans = numbers[0] + numbers[1] + numbers[2];
        for(int i = 0; i < numbers.length - 2; i ++){
            int left = i + 1, right = numbers.length - 1;
            while(left < right){
                int sum = numbers[i] + numbers[left] + numbers[right];
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                if(ans < sum){
                    right --;
                }
                else {
                    left ++;
                }
            }
        }
        return ans;
    }
}
