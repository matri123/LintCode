public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int m1 = 0, m2 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.size(); i ++ ){
            int temp = nums.get(i);
            if(m1 == temp){
                count1 ++;
            }
            else if(m2 == temp){
                count2 ++;
            }
            else if(count1 == 0){
                count1 = 1;
                m1 = temp;
            }
            else if(count2 == 0){
                count2 = 1;
                m2 = temp;
            }
            else {
                count1 --;
                count2 --;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.size(); i ++){
            int temp = nums.get(i);
            if(temp == m1){
                count1 ++;
            }
            else if(temp == m2){
                count2 ++;
            }
        }
        if(count1 > count2){
            return m1;
        }
        else {
            return m2;
        }
    }
}

