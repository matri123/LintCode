public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 3; i ++){
            if(i != 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            for(int j = i + 1; j < numbers.length - 2; j ++){
                if(j != i + 1 && numbers[j] == numbers[j - 1]){
                    continue;
                }
                int left = j + 1, right = numbers.length - 1;
                while(left < right){
                    if(numbers[i] + numbers[j] + numbers[left] + numbers[right] == target){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(numbers[i]);
                        temp.add(numbers[j]);
                        temp.add(numbers[left]);
                        temp.add(numbers[right]);
                        ans.add(temp);
                        left ++;
                        right --;
                        while(left < right && numbers[left] == numbers[left - 1]){
                            left ++;
                        }
                        while(left < right && numbers[right] == numbers[right + 1]){
                            right --;
                        }
                    }
                    else if(numbers[i] + numbers[j] + numbers[left] + numbers[right] < target){
                        left ++;
                    }
                    else {
                        right --;
                    }
                }
            }
        }
        return ans;
    }
}
